package pl.coderslab.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entities.Diagnosis;
import pl.coderslab.entities.Doctor;
import pl.coderslab.entities.Patient;
import pl.coderslab.entities.Prescription;
import pl.coderslab.services.DiagnosisService;
import pl.coderslab.services.DoctorService;
import pl.coderslab.services.PatientService;
import pl.coderslab.services.PrescriptionService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/patients")
@SessionAttributes({"patient"})
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PrescriptionService prescriptionService;



    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("patient", new Patient());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Valid Patient patient, BindingResult result, Model model, HttpSession ses) {
        if (result.hasErrors()) {
            return "login";
        }
        patient.getEmail();
        Patient patientDb = patientService.findByEmail(patient.getEmail());
        boolean isLogged = patientDb != null && BCrypt.checkpw(patient.getPassword(), patientDb.getPassword());
        if (!isLogged) {
            model.addAttribute("loginFailed", true);

            return "login";
        }
        ses.setAttribute("patientId", patientDb.getId());
        return "homePatient";
    }

    @GetMapping("/home")
    public String patientHome() {
        return "homePatient";
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "patientList";
    }

    @GetMapping("/prescriptions")
    public String findPrescriptions(Model model, HttpSession ses) {
        Patient patient = patientService.findWithOthers((Long) ses.getAttribute("patientId"));
        List<Prescription> prescriptions = patient.getPrescriptions();
        model.addAttribute("prescriptions", prescriptions);
        return "prescriptionListPatient";
    }

    @GetMapping("/addPrescription")
    public String showPrescription(Model model, HttpSession ses) {
        Long id = (Long) ses.getAttribute("patientId");
        model.addAttribute("prescription", new Prescription());
        model.addAttribute("id", id);
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);

        return "prescriptionPatient";
    }

    @PostMapping("/addPrescription")
    public String addPrescription(@ModelAttribute Prescription prescription, BindingResult result) {
        if (result.hasErrors()) {
            return "prescriptionPatient";
        }
        prescriptionService.save(prescription);
        return "redirect:patients/prescriptions";
    }

    @GetMapping("/diagnoses")
    public String findDiagnoses(Model model, HttpSession ses) {
        Patient patient = patientService.findWithOthers((Long) ses.getAttribute("patientId"));
        List<Diagnosis> diagnoses = patient.getDiagnoses();
        model.addAttribute("diagnoses", diagnoses);
        return "diagnosisListPatient";
    }

    @GetMapping("/add")
    public String show(Model model) {
        model.addAttribute("patient", new Patient());
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "patient";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "patient";
        }
        patient.setPassword(BCrypt.hashpw(patient.getPassword(), BCrypt.gensalt()));
        patientService.save(patient);
        return "redirect:login";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        patientService.delete(id);
        return "redirect:../home";
    }

    @GetMapping("/update")
    public String update(Model model, HttpSession ses) {
        Patient patient = patientService.findWithOthers((Long) ses.getAttribute("patientId"));
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        model.addAttribute("patient", patient);
        return "patient";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Patient patient, BindingResult result) {
        if(result.hasErrors()) {
            return "patient";
        }
        patient.setPassword(BCrypt.hashpw(patient.getPassword(), BCrypt.gensalt()));
        patientService.update(patient);
        return "redirect:/patients/home";
    }



}

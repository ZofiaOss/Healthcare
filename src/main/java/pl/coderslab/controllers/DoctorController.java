package pl.coderslab.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private DiagnosisService diagnosisService;

    @GetMapping("/home")
    public String home(Model model) {
        return "homeDoctor";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "loginDoctor";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Valid Doctor doctor, BindingResult result, Model model, HttpSession ses) {
        if (result.hasErrors()) {
            return "loginDoctor";
        }
        Doctor doctorDb = doctorService.findByEmail(doctor.getEmail());
        boolean isLogged = doctorDb != null && BCrypt.checkpw(doctor.getPassword(), doctorDb.getPassword());
        if (!isLogged) {
            model.addAttribute("loginFailed", true);
            return "loginDoctor";
        }
        ses.setAttribute("doctorId", doctorDb.getId());
        return "homeDoctor";
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "doctorList";
    }

    @GetMapping("/patientList")
    public String findPatients(Model model, HttpSession ses) {
        Doctor doctor = doctorService.findWithOthers((Long) ses.getAttribute("doctorId"));
        List<Patient> patients = doctor.getPatients();
        model.addAttribute("patients", patients);
        return "patientList";
    }

    @GetMapping("/prescriptionList")
    public String findPrescriptions(Model model, HttpSession ses) {
        Doctor doctor = doctorService.findWithOthers((Long) ses.getAttribute("doctorId"));
        List<Prescription> prescriptions = doctor.getPrescriptions();
        model.addAttribute("prescriptions", prescriptions);
        return "prescriptionList";
    }

    @GetMapping("/add")
    public String show(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Doctor doctor, BindingResult result) {
        if (result.hasErrors()) {
            return "doctor";
        }
        doctor.setPassword(BCrypt.hashpw(doctor.getPassword(), BCrypt.gensalt()));
        doctorService.save(doctor);
        return "redirect:list";
    }

    @GetMapping("/addPrescription")
    public String showPrescription(Model model, HttpSession ses) {
        Long id = (Long) ses.getAttribute("doctorId");
        model.addAttribute("prescription", new Prescription());
        model.addAttribute("id", id);
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "prescriptionDoctor";
    }

    @PostMapping("/addPrescription")
    public String addPrescription(@ModelAttribute Prescription prescription, BindingResult result) {
        if (result.hasErrors()) {
            return "prescriptionDoctor";
        }
        prescriptionService.save(prescription);
        return "redirect:/doctors/prescriptionList";
    }

    @GetMapping("/addDiagnosis")
    public String showDiagnosis(Model model, HttpSession ses) {
        Long id = (Long) ses.getAttribute("doctorId");
        model.addAttribute("diagnosis", new Diagnosis());
        model.addAttribute("id", id);
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "diagnosis";
    }

    @PostMapping("/addDiagnosis")
    public String addDiagnosis(@ModelAttribute Diagnosis diagnosis, BindingResult result) {
        if (result.hasErrors()) {
            return "diagnosis";
        }
        diagnosisService.save(diagnosis);
        return "redirect:/doctors/home";
    }

    @GetMapping("/accept/{id}")
    public String accept(@PathVariable Long id) {
        Prescription prescription = prescriptionService.findWithOthers(id);
        prescription.setPending(false);
        prescription.setAccepted(true);
        prescriptionService.save(prescription);
        return "redirect:../../doctors/prescriptionList";
    }

    @GetMapping("/reject/{id}")
    public String reject(@PathVariable Long id) {
        Prescription prescription = prescriptionService.findWithOthers(id);
        prescription.setPending(false);
        prescription.setAccepted(false);
        prescriptionService.save(prescription);
        return "redirect:../../doctors/prescriptionList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        doctorService.delete(id);
        return "redirect:../list";
    }

    @GetMapping("/update")
    public String update(Model model, HttpSession ses) {
        Doctor doctor = doctorService.findWithOthers((Long) ses.getAttribute("doctorId"));
        model.addAttribute("doctor", doctor);
        return "doctor";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Doctor doctor, BindingResult result) {
        if(result.hasErrors()) {
            return "doctor";
        }
        doctor.setPassword(BCrypt.hashpw(doctor.getPassword(), BCrypt.gensalt()));
        doctorService.update(doctor);
        return "redirect:/doctors/home";
    }

}

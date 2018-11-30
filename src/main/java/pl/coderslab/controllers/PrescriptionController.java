package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.entities.Doctor;
import pl.coderslab.entities.Patient;
import pl.coderslab.entities.Prescription;
import pl.coderslab.services.DoctorService;
import pl.coderslab.services.PatientService;
import pl.coderslab.services.PrescriptionService;

import java.util.List;

@Controller
@RequestMapping("/prescriptions")
@Transactional
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/list")
    public String findAll(Model model) {
        List<Prescription> prescriptions = prescriptionService.findAll();
        model.addAttribute("prescriptions", prescriptions);
        return "prescriptionList";
    }

    @GetMapping("/add")
    public String show(Model model) {

        model.addAttribute("prescription", new Prescription());
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);

        return "prescription";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Prescription prescription, BindingResult result) {
        if (result.hasErrors()) {
            return "prescription";
        }
        prescriptionService.save(prescription);
        return "redirect:list";
    }




    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Prescription prescription = prescriptionService.findWithOthers(id);
        model.addAttribute("prescription", prescription);
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "prescription";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Prescription prescription, BindingResult result) {
        if(result.hasErrors()) {
            return "prescription";
        }
        prescriptionService.update(prescription);
        return "redirect:../list";
    }
}

package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entities.Diagnosis;
import pl.coderslab.entities.Doctor;
import pl.coderslab.entities.Patient;
import pl.coderslab.services.DiagnosisService;
import pl.coderslab.services.DoctorService;
import pl.coderslab.services.PatientService;

import java.util.List;

@Controller
@RequestMapping("/diagnoses")
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private PatientService patientService;





    @GetMapping("/list")
    public String findAll(Model model) {
        List<Diagnosis> diagnoses = diagnosisService.findAll();
        model.addAttribute("diagnoses", diagnoses);
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "diagnosisList";
    }

    @GetMapping("/add")
    public String show(Model model) {
        model.addAttribute("diagnosis", new Diagnosis());
        return "diagnosis";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Diagnosis diagnosis, BindingResult result) {
        if (result.hasErrors()) {
            return "diagnosis";
        }
        diagnosisService.save(diagnosis);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        diagnosisService.delete(id);
        return "redirect:../list";
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Diagnosis diagnosis = diagnosisService.find(id);
        model.addAttribute("diagnosis", diagnosis);
        return "diagnosis";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Diagnosis diagnosis, BindingResult result) {
        if(result.hasErrors()) {
            return "diagnosis";
        }
        diagnosisService.update(diagnosis);
        return "redirect:../list";
    }
}

package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entities.Patient;
import pl.coderslab.services.PatientService;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<Patient> patients = patientService.findAll();
        model.addAttribute("patients", patients);
        return "patientList";
    }

    @GetMapping("/add")
    public String show(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "patient";
        }
        patientService.save(patient);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        patientService.delete(id);
        return "redirect:../list";
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Patient patient = patientService.find(id);
        model.addAttribute("patient", patient);
        return "patient";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Patient patient, BindingResult result) {
        if(result.hasErrors()) {
            return "patient";
        }
        patientService.update(patient);
        return "redirect:../list";
    }



}

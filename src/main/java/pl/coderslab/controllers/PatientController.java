package pl.coderslab.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entities.Patient;
import pl.coderslab.services.PatientService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("patient", new Patient());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Valid Patient patient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }
        Patient patientDb = patientService.findByEmail(patient.getEmail());
        boolean isLogged = patientDb != null && BCrypt.checkpw(patient.getPassword(), patientDb.getPassword());
        if (!isLogged) {
            model.addAttribute("loginFailed", true);
            return "login";
        }
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
        return "home";
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
        patient.setPassword(BCrypt.hashpw(patient.getPassword(), BCrypt.gensalt()));
        patientService.save(patient);
        return "redirect:home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        patientService.delete(id);
        return "redirect:../home";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Patient patient = patientService.findWithOthers(id);
        model.addAttribute("patient", patient);
        return "patient";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Patient patient, BindingResult result) {
        if(result.hasErrors()) {
            return "patient";
        }
        patient.setPassword(BCrypt.hashpw(patient.getPassword(), BCrypt.gensalt()));
        patientService.update(patient);
        return "redirect:../home";
    }



}

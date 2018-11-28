package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entities.Doctor;
import pl.coderslab.services.DoctorService;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;



    @GetMapping("/list")
    public String findAll(Model model) {
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "doctorList";
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
        doctorService.save(doctor);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        doctorService.delete(id);
        return "redirect:../list";
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.find(id);
        model.addAttribute("doctor", doctor);
        return "doctor";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Doctor doctor, BindingResult result) {
        if(result.hasErrors()) {
            return "doctor";
        }
        doctorService.update(doctor);
        return "redirect:../list";
    }
}

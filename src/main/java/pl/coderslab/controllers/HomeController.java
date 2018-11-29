package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.entities.Doctor;
import pl.coderslab.services.DoctorService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    DoctorService doctorService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "home";
    }
}

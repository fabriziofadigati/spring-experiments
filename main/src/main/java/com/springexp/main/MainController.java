package com.springexp.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/index")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/dashboard")
    public String showDashboard(){
        return "dashboard";

    }

    @GetMapping("/signup")
    public String showRegistrationForm(Model model){
        model.addAttribute("patient", new Patient());
        return "signup";

    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("patient") Patient patient){
        this.patientService.registerPatient(patient);
        return "success-signup";
    }
    
}

package com.mini_project_2.Hospital_Management_Application.Controller;

import com.mini_project_2.Hospital_Management_Application.Entity.Doctor;
import com.mini_project_2.Hospital_Management_Application.Entity.Patient;
import com.mini_project_2.Hospital_Management_Application.Repository.DoctorRepository;
import com.mini_project_2.Hospital_Management_Application.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping({"/"})
    public String loggedIn(@AuthenticationPrincipal User user, Model model) {
        String username = user.getUsername();

        String url = "";
        if (doctorRepository.findByEmail(username) != null) {
            Doctor doc = doctorRepository.findByEmail(username);
            long docId = doc.getDoctor_id();
            url = "redirect:/doctor/" + docId;
        } else if (patientRepository.findByEmail(username) != null) {
            Patient pat = patientRepository.findByEmail(username);
            int patId = pat.getPatient_id();
            url = "redirect:/patient/" + patId;
        }
        return url;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return "redirect:/dashboard";
    }
}

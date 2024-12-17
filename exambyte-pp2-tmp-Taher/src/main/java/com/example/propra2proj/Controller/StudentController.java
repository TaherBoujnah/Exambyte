package com.example.propra2proj.Controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/Student/old_exams")
    @Secured("ROLE_STUDENT")
    public String oldExams() {
        return "Student/old_exams";
    }

    @GetMapping("/Student/available_exams")
    @Secured("ROLE_STUDENT")
    public String availableExams() {
        return "Student/available_exams";
    }

    @GetMapping("/Student/student_dashboard")
    public String studentDashboard(OAuth2AuthenticationToken auth, Model model) {
        model.addAttribute("name", auth.getName());
        return "Student/student_dashboard";}

}

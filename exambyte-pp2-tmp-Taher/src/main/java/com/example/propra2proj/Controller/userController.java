package com.example.propra2proj.Controller;


import com.example.propra2proj.MultipleChoiceQuestion;
import com.example.propra2proj.Question;
import com.example.propra2proj.Test_Exam;
import com.example.propra2proj.Text_Question;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class userController {



    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }


    @GetMapping("/Student/student_dashboard")
    public String studentDashboard(OAuth2AuthenticationToken auth, Model model) {
        model.addAttribute("name", auth.getName());
        return "/Student/student_dashboard";}

    @GetMapping("/home")
    public String home() {return "home";}

    @GetMapping("/default")
    public void defaultAfterLogin(Authentication authentication, HttpServletResponse response) throws Exception {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_STUDENT"))) {
            response.sendRedirect("/Student/student_dashboard");
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CORRECTOR"))) {
            response.sendRedirect("/Corrector/corrector_dashboard");
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ORGANISER"))) {
            response.sendRedirect("/Organiser/organiser_dashboard");
        } else {
            response.sendRedirect("/home");
        }
    }

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

    @GetMapping("/Corrector/corrector_dashboard")
    @Secured("ROLE_CORRECTOR")
    public String CorrectorDashboard(OAuth2AuthenticationToken auth, Model model) {
        model.addAttribute("name", auth.getName());
        return "Corrector/corrector_dashboard";
    }

    @GetMapping("/Organiser/organiser_dashboard")
    @Secured("ROLE_ORGANISER")
    public String OrganiserDashboard(OAuth2AuthenticationToken auth, Model model) {
        model.addAttribute("name", auth.getName());
        return "Organiser/organiser_dashboard";
    }
















}

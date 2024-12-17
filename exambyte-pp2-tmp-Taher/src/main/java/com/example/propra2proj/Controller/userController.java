package com.example.propra2proj.Controller;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class userController {



    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }




    @GetMapping("/home")
    public String home() {return "home";}

    @GetMapping("/default")
    public void defaultAfterLogin(Authentication authentication, HttpServletResponse response) throws Exception {
        String username = authentication.getName();

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






}

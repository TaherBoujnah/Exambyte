package com.example.propra2proj.Controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class CorrectorController {


    @GetMapping("/Corrector/corrector_dashboard")
    @Secured("ROLE_CORRECTOR")
    public String CorrectorDashboard(OAuth2AuthenticationToken auth, Model model) {
        model.addAttribute("name", auth.getName());
        return "/Corrector/corrector_dashboard";
    }


    @GetMapping("/Corrector/OldCorrectedExams")
    @Secured("ROLE_CORRECTOR")
    public String Corrector_old() {
        return "/Corrector/OldCorrectedExams";
    }

}

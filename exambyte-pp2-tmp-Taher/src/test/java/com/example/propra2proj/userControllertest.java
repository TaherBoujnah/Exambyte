package com.example.propra2proj;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;


import com.example.propra2proj.Controller.userController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest (userController.class)
public class userControllertest {
    @Autowired private MockMvc mvc;


    @Test
    @DisplayName("Testing the get mapping of the home page and default page")
    void TestMain () throws Exception {
    mvc.perform(get("/")).andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/home"));
        String str= mvc.perform(get("/home")).andReturn().getResponse().getContentAsString();
        assertThat(str).contains("Exambyte") ;
    }

    private OAuth2AuthenticationToken createOAuthToken(String role) {
        Collection<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(role));
        Map<String, Object> attributes = Map.of("name", "TestUser", "login", "TestUser");
        OAuth2User user = new DefaultOAuth2User(authorities, attributes, "login");
        return new OAuth2AuthenticationToken(user, authorities, "clientRegistrationId");
    }

    @Test()
    @DisplayName("Testing the authentication and different accesses")
    void TestAuthentication() throws Exception {
       OAuth2AuthenticationToken studentAuth= createOAuthToken("ROLE_STUDENT");

       mvc.perform(get("/default").with(authentication(studentAuth))).andExpect(status().is3xxRedirection())
               .andExpect(redirectedUrl("/Student/student_dashboard"));

        OAuth2AuthenticationToken OrgAuth= createOAuthToken("ROLE_ORGANISER");

        mvc.perform(get("/default").with(authentication(OrgAuth))).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/Organiser/organiser_dashboard"));

        OAuth2AuthenticationToken CorrectorAuth= createOAuthToken("ROLE_CORRECTOR");

        mvc.perform(get("/default").with(authentication(CorrectorAuth))).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/Corrector/corrector_dashboard"));

    }

    @Test
    @DisplayName("Test to see if we can access dashboards without any role")
    public void testAccessDashboard () throws Exception {
        mvc.perform(get("/Student/student_dashboard")).andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/login?error"));

    }

    @Test
    @WithMockUser(roles = "ORGANISER")
    public void testOrganiserDashboard () throws Exception {
        mvc.perform(get("/Organiser/organiser_dashboard")).andExpect(status().isOk())
                .andExpect(view().name("Organiser/organiser_dashboard"))      ;

    }

    @Test
    @WithMockUser(roles = "STUDENT")
    public void testStudentDashboard () throws Exception {
        mvc.perform(get("/Student/student_dashboard")).andExpect(status().isOk())
                .andExpect(view().name("Student/student_dashboard"));

    }

    @Test
    @WithMockUser(roles = "CORRECTOR")
    public void testCorrectorDashboard () throws Exception {
        mvc.perform(get("/Corrector/corrector_dashboard")).andExpect(status().isOk())
                .andExpect(view().name("Corrector/organiser_dashboard"));

    }

    @Test

    public void testCreateExam () throws Exception {
        mvc.perform(get("/Organiser/create_exams")).andExpect(status().isOk());
        mvc.perform(post("/Organiser/step1")).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/Organiser/exam_forms"));
    }
    //@Test
    //@WithMockUser(roles ="ORGANISER" )
    //public void testExamForms () throws Exception {
        //mvc.perform(get("/Organiser/exam_forms")).andExpect(status().isOk());
        //mvc.perform(post("/saveExam")).andExpect(status().is3xxRedirection())
                //.andExpect(redirectedUrl("/Organiser/organiser_dashboard"));
    //}







}

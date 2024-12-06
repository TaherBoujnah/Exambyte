package com.example.propra2proj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //CLIENT_ID  Ov23liIph6V66VAtEf0U
        //CLIENT SECRET 6f6c1e78031400ef1736aa3b3e5874a4517be0cf
        http.authorizeHttpRequests(configurer -> configurer.requestMatchers("/","/home","/StyleSheet.css").permitAll()

                        .requestMatchers("/Student/student_dashboard").hasRole("STUDENT")
                        .requestMatchers("/Corrector/corrector_dashboard").hasRole("CORRECTOR")
                        .requestMatchers("/Organiser/organiser_dashboard").hasRole("ORGANISER")
                        .anyRequest().authenticated())
                        .oauth2Login(oauth2 -> oauth2
                                .defaultSuccessUrl("/default", true))
                        .formLogin(form -> form
                                .loginPage("/login").permitAll()
                                .defaultSuccessUrl("/default", true)   )
                        .logout(logout -> logout.logoutSuccessUrl("/home").permitAll()) ;


        return http.build();}





}
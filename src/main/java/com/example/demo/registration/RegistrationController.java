package com.example.demo.registration;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;


    /*  HTTP GET Request for read registartion.html page from server */
     @GetMapping("/registration")
     public String showRegistrationPanel(Model model) {
         RegistrationDTO registrationDTO = new RegistrationDTO();
         model.addAttribute("systemUser",registrationDTO);
         return "registration";
     }

     /*  HTTP POST Request for insert data to database on server */
     @PostMapping("/registration")
     public String registerNewUser(@ModelAttribute("systemUser") RegistrationDTO registrationDTO) {

           System.out.println(registrationDTO.getName());
           System.out.println(registrationDTO.getUsername());
           System.out.println(registrationDTO.getPassword());
           System.out.println(registrationDTO.getEmail());

           try {
               registrationService.register(registrationDTO);
           }catch(NullPointerException exception) {
               exception.printStackTrace();
           }
           return "redirect:/registration?success";
     }

}

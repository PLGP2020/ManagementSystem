package com.example.demo.agency;


import com.example.demo.address.Address;
import com.example.demo.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AgencyController {

    private AgencyService agencyService;
    private AddressService addressService;


    @Autowired
    public AgencyController(AgencyService agencyService,AddressService addressService) {
        this.agencyService = agencyService;
        this.addressService = addressService;

    }

    @GetMapping("/agencies")
    public String getAgencies(Model model) {
        model.addAttribute("agencies",agencyService.getAgencies());
        return "agencies";
    }

    /*  GET HTTP Request for form to add new agency to database */
    @GetMapping("/agencies/new")
    public String newAgencyPage(Model model) {
           Agency newAgency = new Agency();
           Address newAddress = new Address();
           model.addAttribute("agency",newAgency);
           model.addAttribute("address",newAddress);
           return "newAgency";
    }

    /* POST HTTP Request for put data to database*/
    @PostMapping("/agencies/save")
    public String saveAgency(@ModelAttribute("agency") Agency agency,@ModelAttribute("address") Address address) {
        System.out.println(agency.getPhoneNumber());
        System.out.println(agency.getEmail());

        agencyService.saveAgency(agency);
        System.out.println(agency.getAddress().getPostalCode());
        addressService.saveAddress(address);

        return "redirect:/agencies";
    }




}

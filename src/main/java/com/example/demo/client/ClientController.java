package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller("clientController")
public class ClientController {


    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }



    /* GET HTTP  Request for list of clients from database */
    @GetMapping("/clients")
    public String getAllClients(Model model) {
        List<Client> clientList = clientService.getClients();
        model.addAttribute("client",clientList);
        return "clients";
    }

    /* GET HTTP Request for page to create new client */
    @GetMapping("/clients/new")
    public String createClientPanel(Model model) {
        Client newClient = new Client();
        model.addAttribute("client",newClient);
        return "newClient";
    }

    /* POST HTTP Request for add client to database */
    @PostMapping("/clients/save")
    public String saveClient(@ModelAttribute("client") Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    /* GET HTTP Request for editing client page */
    @GetMapping("/clients/edit/{id}")
    public  String editClientPanel(@PathVariable Long id, Model model) {
        model.addAttribute("client",clientService.findClientByID(id));
        return "editClient";
    }

    /* DELETE HTTP Request for deleting client */
    @GetMapping("/clients/{id}")
    public String deleteClient(@PathVariable Long id) {
        Client deletedClient = clientService.findClientByID(id);
        clientService.deleteClient(deletedClient,id);
        return "redirect:/clients";
    }

    /* POST HTTP Request for put edited client to database */
    @PostMapping("/clients/{id}")
    public String editClient(@PathVariable Long id,@ModelAttribute("client") Client client,Model model) {
        Client updatedClient = clientService.findClientByID(id);
        updatedClient.setId(id);
        updatedClient.setFirstName(client.getFirstName());
        updatedClient.setLastName(client.getLastName());
        updatedClient.setEmail(client.getEmail());
        updatedClient.setPhoneNumber(client.getPhoneNumber());
        updatedClient.setAge(client.getAge());
        updatedClient.setGender(client.getGender());
        clientService.editClient(updatedClient,id);
        return "redirect:/clients";
    }

    @GetMapping("/clients/info/{id}")
    public String profilePanel(@PathVariable Long id, Model model)  {
        model.addAttribute("client",clientService.findClientByID(id));
        return "customerProfile";
    }

}

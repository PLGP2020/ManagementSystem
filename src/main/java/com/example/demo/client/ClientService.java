package com.example.demo.client;


import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("clientService")
@AllArgsConstructor
@Data
@Transactional
public class ClientService {


    private final static String USER_NOT_FOUND = "user with email %s not found";
    private final ClientRepository clientRepository;

  //  private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public List<Client> getClients() {
        return clientRepository.findAll();
    }


    public Client saveClient(Client client) {
     return  clientRepository.saveAndFlush(client);
    }

    public void deleteClient(Client client,Long id) {
        clientRepository.deleteById(id);
    }

    public Client editClient(Client client,Long id) {
        return clientRepository.saveAndFlush(client);
    }

    public Client findClientByID(Long id) {
        return  clientRepository.getById(id);
    }


   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientRepository.findByEmail(username).
                orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND,username)));
    }

    /*  */

 //  public String signUpClient(Client client) {
      /*  boolean userExists = clientRepository.findByEmail(client.getEmail()).isPresent();

        if(userExists) {
            throw new IllegalStateException("email already taken");
        }
     */
         //    String encodedPassword = bCryptPasswordEncoder.encode(client.getPassword());

         // client.setPassword(encodedPassword);

    //    clientRepository.save(client);

     //  return "it works";
  //  }


}


package com.example.demo.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class SystemUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "user with email %s not found";

      @Autowired
      private  BCryptPasswordEncoder bCryptPasswordEncoder;

      private SystemUserRepository systemUserRepository;

  @Autowired
  public SystemUserService(SystemUserRepository systemUserRepository) {

    this.systemUserRepository = systemUserRepository;
  }


      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         return systemUserRepository.findByEmail(username).
                orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND,username)));
        }



      public  String signUpUser(SystemUser systemUser) {
        boolean userExists = systemUserRepository.findByEmail(systemUser.getEmail()).isPresent();

        if(userExists) {
            throw new IllegalStateException("email already taken");
        }

        systemUserRepository.save(systemUser);

        return "it works";
      }

}

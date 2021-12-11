package com.example.demo.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class SystemUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "user with email %s not found";


      private  BCryptPasswordEncoder bCryptPasswordEncoder;

      private SystemUserRepository systemUserRepository;

  @Autowired
  public SystemUserService(SystemUserRepository systemUserRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {

    this.systemUserRepository = systemUserRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }


      @Override
      public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

         return systemUserRepository.findByEmail(email).
                orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND,email)));
        }



      public  String signUpNewUser(SystemUser systemUser) {
        boolean userExists = systemUserRepository.findByEmail(systemUser.getEmail()).isPresent();

        if(userExists) {
            throw new IllegalStateException("email already taken");
        }
          String encodedPassword = bCryptPasswordEncoder
                  .encode(systemUser.getPassword());

          systemUser.setPassword(encodedPassword);

          systemUserRepository.save(systemUser);

        return "it works";
      }

}

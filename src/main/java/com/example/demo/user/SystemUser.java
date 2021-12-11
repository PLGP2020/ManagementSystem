package com.example.demo.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity(name="systemUser")
@Table(name = "systemUser")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SystemUser implements UserDetails {

         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         @Column(name="id" ,nullable = false)
         private Long id;
         @Column(name="name")
         private String name;
         @Column(name="username")
         private String username;
         @Column(name="password")
         private String password;
         @Column(name="email")
         private String email;
         @Column(name="appUserRole")
         @Enumerated(EnumType.STRING)
         private SystemUserRole appUserRole;
         private boolean locked;
         private boolean enabled;

    public SystemUser(String name, String username, String password, String email,
                      SystemUserRole appUserRole) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.appUserRole = appUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singleton(authority);
    }

    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}

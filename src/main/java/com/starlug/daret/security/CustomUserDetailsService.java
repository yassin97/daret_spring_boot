package com.starlug.daret.security;

import com.starlug.daret.entity.Role;
import com.starlug.daret.entity.User;
import com.starlug.daret.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.SessionAttributeStore;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    private HttpSession httpSession;

    public CustomUserDetailsService(UserRepository userRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            httpSession.setAttribute("loggedInUsername", user.getEmail());
            System.out.println(user.getEmail());
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}


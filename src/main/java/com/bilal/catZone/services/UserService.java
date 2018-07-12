package com.bilal.catZone.services;


import com.bilal.catZone.models.Role;
import com.bilal.catZone.models.User;
import com.bilal.catZone.repos.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class UserService/* implements UserDetailsService*/ {

   /* @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User aUser = findByEmail(username);
        if (aUser == null) {
            throw new UsernameNotFoundException(username);
        } else {
            Role role = aUser.getRole();
            return new UserDetailsImpl(aUser , role);
        }
    }*/
}

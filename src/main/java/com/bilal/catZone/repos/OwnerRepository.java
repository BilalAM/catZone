package com.bilal.catZone.repos;

import com.bilal.catZone.models.Cat;
import com.bilal.catZone.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Owner findByOwnerName(String ownerName);
    List<Owner> findByOwnerNameContainingIgnoreCase(String ownerName);
    Owner findByCatsCatName(String catName);
    List<Owner> findByRoleRoleName(String roleName);

    Owner findByOwnerEmail(String email);



    @Transactional
    void deleteCatByCats_CatName(String catName);
}
/*
package com.bilal.catZone.controllers;


;
import com.bilal.catZone.models.Cat;
import com.bilal.catZone.models.Owner;
import com.bilal.catZone.models.Role;
import com.bilal.catZone.models.User;
import com.bilal.catZone.repos.OwnerRepository;
import com.bilal.catZone.repos.UserRepository;
import com.bilal.catZone.services.OwnerService;
import com.bilal.catZone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginAndRegisterController {


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerRepository ownerRepository;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String redirectToHome() {
        return "home";
    }


    @PostMapping("/register")
    public String register(@RequestParam(name = "userEmail", required = true) String userEmail,
                           @RequestParam(name = "userPassword", required = true) String password
            , Model messages) {

        Owner owner = ownerRepository.findByOwnerEmail(userEmail);
        if (owner != null) {
            return "redirect:/login";
        } else {
            owner = new Owner(userEmail);
            owner.setOwnerEmail(userEmail);
            owner.setOwnerPassword(bCryptPasswordEncoder.encode(password));
            owner.setRole(new Role("ROLE_USER"));
            ownerRepository.save(owner);
            System.out.println(userEmail + "   " + password);
        }
        return "redirect:/home";
    }

}


 */
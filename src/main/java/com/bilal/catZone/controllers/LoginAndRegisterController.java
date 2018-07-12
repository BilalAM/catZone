package com.bilal.catZone.controllers;



import com.bilal.catZone.models.Owner;
import com.bilal.catZone.models.Role;
import com.bilal.catZone.repos.OwnerRepository;
import com.bilal.catZone.services.OwnerDetailsImpl;
import com.bilal.catZone.services.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class LoginAndRegisterController {


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerRepository ownerRepository;

   // private Owner owner;

    @GetMapping("/")
    public String root(Principal user, Model model) {
        if (user != null) {
            OwnerDetailsImpl owner = (OwnerDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("owner", owner.getOwner());
            return "redirect:/home";
        } else {
            return "login";
        }
    }

    @GetMapping("/login")
    public String login(Principal user, Model model) {
        if (user != null) {
            OwnerDetailsImpl owner = (OwnerDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("owner", owner.getOwner());
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/home")
    public String redirectToHome(Principal user , Model model) {
        if (user != null) {
            OwnerDetailsImpl owner = (OwnerDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("owner", owner.getOwner());
            System.out.println(owner.getOwner().getFirstTime());
            return "home";
        } else {
            return "login";
        }

    }

    /**
     * First Time Registration
     * @param userEmail
     * @param password
     * @param userName
     *
     */
    @PostMapping("/register")
    public String register(@RequestParam(name = "userEmail", required = true) String userEmail,
                           @RequestParam(name = "userPassword", required = true) String password
            , @RequestParam(name = "userName", required = true) String userName) {

        Owner owner = ownerRepository.findByOwnerEmail(userEmail);
        if (owner != null) {
            return "redirect:/login";
        } else {
            owner = new Owner(userName);
            owner.setOwnerEmail(userEmail);
            owner.setOwnerPassword(bCryptPasswordEncoder.encode(password));
            owner.setRole(new Role("ROLE_USER"));
            owner.setIsFirstTime(true);
            ownerRepository.save(owner);
            System.out.println("EMAIL =" + userEmail + "  PASSWORD =  " + password + "  USERNAME=  " + owner.getOwnerName());
        }
        return "redirect:/login";
    }

}


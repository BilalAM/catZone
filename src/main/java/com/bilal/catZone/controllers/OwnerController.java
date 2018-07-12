package com.bilal.catZone.controllers;


import com.bilal.catZone.models.Cat;
import com.bilal.catZone.models.Owner;
import com.bilal.catZone.models_embedded.OwnerImage;
import com.bilal.catZone.repos.OwnerRepository;
import com.bilal.catZone.services.AbstractImageComponent;
import com.bilal.catZone.services.OwnerDetailsImpl;
import com.bilal.catZone.services.OwnerService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

@Controller
public class OwnerController {

    /**
     * TODO : try to get the owner name
     */
    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private AbstractImageComponent abstractImageComponent;

    @Autowired
    private Environment env;

    @GetMapping("/greet")
    public String greetOwner(@RequestParam(name = "name", required = false, defaultValue = "bilal") String ownerName
            , Model model) {
        model.addAttribute("ownerName", ownerName);
        return "greetings";
    }


    @GetMapping("/owners")
    public String allOwners(@RequestParam(name = "byName", required = false, defaultValue = "") String byName,
                            Model model) {
        model.addAttribute("owners", ownerService.getAllOwners());
        model.addAttribute("byName", ownerRepository.findByOwnerNameContainingIgnoreCase(byName));
        System.out.println(byName);
        return "owners";
    }

    @PostMapping("/deleteOwnerCat")
    public String deleteOwnerCat(@RequestParam(name = "catName") String catName) {
        ownerService.deleteOwnerCat(catName);
        return "redirect:/owners";
    }

    @PostMapping("/deleteOwner")
    public String deleteOwner(@RequestParam(name = "ownerId") int ownerId) {
        ownerService.deleteOwner(ownerId);
        return "redirect:/owners";
    }


    @GetMapping("/owners/view/{ownerName}")
    public String viewOwner(@PathVariable String ownerName,
                            Model model) {
        Owner owner = ownerRepository.findByOwnerName(ownerName);
        if (owner.getOwnerName() == null) {
            String message = "OWNER NAME " + ownerName + " CANNOT BE FOUND , MAKE SURE THE NAME IS CORRECT";
            model.addAttribute("message", message);
        } else {
            model.addAttribute("owner", owner);
        }
        return "owner_profile";
    }

    @PostMapping("/home/firstTime")
    public String postNewOwner(@RequestParam(name = "ownerName", required = false) String ownerName,
                               @RequestParam(name = "ownerImage", required = false) MultipartFile ownerImage,
                               @RequestParam(name = "ownerFollowers", required = false, defaultValue = "") List<Owner> followers,
                               Principal currentOwner,
                               @RequestParam(name = "ownerCats", required = false, defaultValue = "") Cat... cats) {
        File file = null;
        OwnerImage owner_image = null;

        try {
            OwnerDetailsImpl ownerDetails = (OwnerDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (abstractImageComponent.validateImageFile(ownerImage)) {
                file = abstractImageComponent.convertAndSave(ownerImage, ownerName, env.getProperty("uploaded.owner.images"));
                owner_image = new OwnerImage("UPLOADED_OWNER_IMAGES/" + file.getName());
            }
            Owner loggedinUser = ownerDetails.getOwner();
            loggedinUser.setOwnerImage(owner_image);
            loggedinUser.setOwnerName(ownerName);
            loggedinUser.setIsFirstTime(false);
            loggedinUser.setCats(cats);
            loggedinUser.setFollowers(followers);
            ownerService.addOwner(loggedinUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/home";
    }

}

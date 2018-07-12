package com.bilal.catZone.controllers;


import com.bilal.catZone.models.Cat;
import com.bilal.catZone.models_embedded.CatImage;
import com.bilal.catZone.services.AbstractImageComponent;
import com.bilal.catZone.services.CatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Controller
public class CatController {

    private static final String UPLOADED_CATS_IMAGES_FOLDER = "/static/uploaded_cats/";

    @Autowired
    Environment environment;

    @Autowired
    CatService catService;

    @Autowired
    AbstractImageComponent abstractImageService;

    @GetMapping("/cats")
    public String allCats(Model model) {
        model.addAttribute("cats", catService.findAllCats());
        return "cats";
    }

    @PostMapping("/newCat")
    public String newCat(@RequestParam(name = "catName", defaultValue = "") String catName,
                         @RequestParam(name = "furDensity", defaultValue = "0") double furDensity,
                         @RequestParam(name = "catPicture", required = false) MultipartFile catImage,
                         Model model) {
        try {
            File file = null;
            CatImage image = null;
            Cat cat = null;

            if (abstractImageService.validateImageFile(catImage)) {
                file = abstractImageService
                        .convertAndSave(catImage, catName, environment.getProperty("uploaded.cat.images"));
                image = new CatImage("UPLOADED_CAT_IMAGES/" + file.getName());
                cat = new Cat(furDensity, catName, image);
                catService.addCat(cat);
            }else{
                model.addAttribute("imageFormatWrong" , "The Image Format Is Not Valid" +
                        " , The Supported Types Are jpg and/or png..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/cats";
    }


    @PostMapping("/deleteCat")
    public String deleteCat(@RequestParam(name = "catId") int catId) {
        catService.deleteCat(catId);
        return "redirect:/cats";
    }


}

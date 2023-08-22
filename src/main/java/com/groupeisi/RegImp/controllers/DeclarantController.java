package com.groupeisi.RegImp.controllers;

import com.groupeisi.RegImp.entities.Declarant;
import com.groupeisi.RegImp.services.DeclarantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/declarants")
public class DeclarantController {
    @Autowired
    private DeclarantService declarantService;

    @GetMapping("/add")
    public String showAddDeclarantForm(Model model) {
        model.addAttribute("declarant", new Declarant());
        return "declarant-form"; // Correspond au nom du template Thymeleaf
    }
    @PostMapping("/add")
    public String addDeclarant(@ModelAttribute Declarant declarant) {
        declarantService.addDeclarant(declarant);
        return "redirect:/declarants"; // Redirection vers la liste des déclarants
    }

    // Ajoutez d'autres méthodes pour l'édition et d'autres fonctionnalités

    @GetMapping
    public String showDeclarants(Model model) {
        model.addAttribute("declarants", declarantService.getAllDeclarants());
        return "declarant-list"; // Correspond au nom du template Thymeleaf
    }
}

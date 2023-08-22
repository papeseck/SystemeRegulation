package com.groupeisi.RegImp.controllers;

import com.groupeisi.RegImp.entities.Declarant;
import com.groupeisi.RegImp.entities.Declaration;
import com.groupeisi.RegImp.services.DeclarantService;
import com.groupeisi.RegImp.services.DeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/declarations")
public class DeclarationController {
    @Autowired
    private DeclarationService declarationService;

    @Autowired
    private DeclarantService declarantService;

    @GetMapping("/add")
    public String showAddDeclarationForm(Model model) {
        model.addAttribute("declaration", new Declaration());
        return "declaration-form"; // Correspond au nom du template Thymeleaf
    }

    @PostMapping("/add")
    public String addDeclaration(@ModelAttribute Declaration declaration) throws ChangeSetPersister.NotFoundException {
        Long declarantId = declaration.getDeclarant().getId(); // Récupérer l'ID du déclarant
        Declarant declarant = declarantService.getDeclarantById(declarantId); // Récupérer le déclarant par l'ID
        declaration.setDeclarant(declarant); // Associer le déclarant à la déclaration
        declarationService.addDeclaration(declaration);
        return "redirect:/declarations";
    }


    // Ajoutez d'autres méthodes pour l'édition et d'autres fonctionnalités

    @GetMapping
    public String showDeclarations(Model model) {
        model.addAttribute("declarations", declarationService.getAllDeclarations());
        return "declaration-list"; // Correspond au nom du template Thymeleaf
    }
}

package com.groupeisi.RegImp.controllers;


import com.groupeisi.RegImp.entities.Paiement;
import com.groupeisi.RegImp.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paiements")
public class PaiementController {
    @Autowired
    private PaiementService paiementService;

    @GetMapping("/add")
    public String showAddPaiementForm(Model model) {
        model.addAttribute("paiement", new Paiement());
        return "paiement-form"; // Correspond au nom du template Thymeleaf
    }
    @PostMapping("/add")
    public String addPaiement(@ModelAttribute Paiement paiement) {
        paiementService.addPaiement(paiement);
        return "redirect:/paiements"; // Redirection vers la liste des paiements
    }

    // Ajoutez d'autres méthodes pour l'édition et d'autres fonctionnalités

    @GetMapping
    public String showPaiements(Model model) {
        model.addAttribute("paiements", paiementService.getAllPaiements());
        return "paiement-list"; // Correspond au nom du template Thymeleaf
    }
}

package com.groupeisi.RegImp.services;

import com.groupeisi.RegImp.dao.DeclarationRepository;
import com.groupeisi.RegImp.entities.Declaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService {
    @Autowired
    private DeclarationRepository declarationRepository;

    public Declaration addDeclaration(Declaration declaration) {
        return declarationRepository.save(declaration);
    }

    public List<Declaration> getAllDeclarations() {
        return declarationRepository.findAll();
    }
}

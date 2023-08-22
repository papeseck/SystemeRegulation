package com.groupeisi.RegImp.services;

import com.groupeisi.RegImp.dao.PaiementRepository;
import com.groupeisi.RegImp.entities.Paiement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService {
    @Autowired
    private PaiementRepository paiementRepository;

    public Paiement addPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }
}

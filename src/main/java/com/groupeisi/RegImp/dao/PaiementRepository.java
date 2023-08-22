package com.groupeisi.RegImp.dao;

import com.groupeisi.RegImp.entities.Declarant;
import com.groupeisi.RegImp.entities.Declaration;
import com.groupeisi.RegImp.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    // Méthode pour rechercher des paiements par date de paiement
    List<Paiement> findByDatePaiementBetween(LocalDate startDate, LocalDate endDate);

    // Méthode pour rechercher des paiements par montant
    List<Paiement> findByMontantPaiementGreaterThan(double montant);

    // Méthode pour rechercher des paiements d'une certaine déclaration
    List<Paiement> findByDeclaration(Declaration declaration);
}

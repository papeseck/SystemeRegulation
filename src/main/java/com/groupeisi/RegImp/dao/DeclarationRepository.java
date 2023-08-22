package com.groupeisi.RegImp.dao;

import com.groupeisi.RegImp.entities.Declarant;
import com.groupeisi.RegImp.entities.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DeclarationRepository extends JpaRepository<Declaration, Long> {
    // Méthode pour rechercher des déclarations par montant de déclaration
    List<Declaration> findByMontantDeclarationGreaterThan(double montant);

    // Méthode pour rechercher des déclarations par date de déclaration
    List<Declaration> findByDateDeclaration(LocalDate dateDeclaration);

    // Méthode pour rechercher des déclarations pour un déclarant spécifique
    List<Declaration> findByDeclarant(Declarant declarant);

    // Méthode pour rechercher des déclarations pour un déclarant donné et avec un montant spécifique
    List<Declaration> findByDeclarantAndMontantDeclarationGreaterThan(Declarant declarant, double montant);
}

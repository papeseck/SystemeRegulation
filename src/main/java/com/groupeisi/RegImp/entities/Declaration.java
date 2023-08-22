package com.groupeisi.RegImp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateDeclaration;
    private double montantDeclaration;

    @ManyToOne
    @JoinColumn(name = "declarant_id")
    private Declarant declarant;

    @OneToMany(mappedBy = "declaration", cascade = CascadeType.ALL)
    private List<Paiement> paiements = new ArrayList<>();
}

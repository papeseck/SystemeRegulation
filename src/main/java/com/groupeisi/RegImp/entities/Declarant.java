package com.groupeisi.RegImp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Declarant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String raisonSociale;
    private String adresse;
    private String email;
    private String telephone;

    @OneToMany(mappedBy = "declarant", cascade = CascadeType.ALL)
    private List<Declaration> declarations = new ArrayList<>();
}

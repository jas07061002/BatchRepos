package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ACCOUNT_BENE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountBene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_BENE_ID")
    private Integer accountBeneId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
/*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumns( {@JoinColumn(name = "BENE_ID")
         //   , @JoinColumn(name = "ACCOUNT_ID")
    })
  //  @ManyToOne(cascade = CascadeType.ALL)
  //  @JoinColumn(name = "BENE_ID", referencedColumnName = "BENE_ID")
      private List<GeneralTrustBene> generalTrustBenes = new ArrayList<>();*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BENE_ID", referencedColumnName = "BENE_ID")
     private GeneralTrustBene generalTrustBenes;




}

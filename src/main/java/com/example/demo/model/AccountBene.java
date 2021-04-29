package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
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

    @Column(name = "per")
    private Integer per;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BENE_ID", referencedColumnName = "BENE_ID")
    private GeneralTrustBene generalTrustBenes;

    public AccountBene(Integer per, Account account, GeneralTrustBene generalTrustBenes) {
        this.per = per;
        this.account = account;
        this.generalTrustBenes = generalTrustBenes;
    }
}

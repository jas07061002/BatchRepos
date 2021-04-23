package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "ACCOUNT")
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ACCOUNT_ID")
    public Integer accountID;

    @Column(name="ACCOUNT_NO")
    public Integer accountNum;

    @Column(name="BRANCH_NO")
    public Integer branchNum;

    @Column(name="ACCOUNT_TYPE")
    public String accountType;

    @Column(name="ACCOUNT_STATUS")
    public String accountStatus;

    @Column(name="CDIC_TRUST_TYPE")
    public String cdicTrustType;

    @Column(name="ACCOUNT_CLOSED_DATE")
    public Timestamp accountClosedDate;

    @Column(name="LAST_UPDATE_TIME")
    public Timestamp lastUpdateTime;

  /*  @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    private List<GeneralTrustBene> generalTrustBeneList;*/


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ACCOUNT",
            joinColumns = { @JoinColumn(name = "ACCOUNT_ID") },
            inverseJoinColumns = { @JoinColumn(name = "BENE_ID") })
    private List<AccountBene> accountBenes;




}

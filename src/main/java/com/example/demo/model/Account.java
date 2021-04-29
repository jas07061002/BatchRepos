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
    @GeneratedValue(generator = "seq1")
    @SequenceGenerator(name = "seq1", initialValue = 1000, allocationSize = 1)
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

   /* @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(  name = "ACCOUNT_BENE",
    joinColumns ={
            @JoinColumn(name = "ACCOUNT_ID")},
            inverseJoinColumns = {
                    @JoinColumn(name = "BENE_ID")})
    private List<GeneralTrustBene> generalTrustBeneList;*/

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    //@JoinColumn(name = "ACCOUNT_ID")
    private List<AccountBene> accountBenes;

    public Account(Integer accountNum, Integer branchNum, String accountType, String accountStatus, String cdicTrustType, Timestamp accountClosedDate, Timestamp lastUpdateTime,
                   List<AccountBene> accountBenes) {
        this.accountNum = accountNum;
        this.branchNum = branchNum;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.cdicTrustType = cdicTrustType;
        this.accountClosedDate = accountClosedDate;
        this.lastUpdateTime = lastUpdateTime;
      //  this.generalTrustBeneList = generalTrustBeneList;
        this.accountBenes = accountBenes;
    }
}

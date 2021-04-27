package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="GENERAL_TRUST_BENE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeneralTrustBene {

    @Id
    @GeneratedValue(generator = "seq")
    @SequenceGenerator(name = "seq", initialValue = 2000, allocationSize = 1)
    @Column(name="BENE_ID")
    public Integer beneId;

    @Column(name="BENE_TYPE")
    public Character beneType;

    @Column(name="BENE_ENTITY_NAME")
    public String entityName;

    @Column(name="FIRST_NAME")
    public String firstName;

    @Column(name="LAST_NAME")
    public String lastName;

    @Column(name="MIDDLE_NAME")
    public String middleName;

    @Column(name="ADDRESS_LINE_1")
    public String addressLine1;

    @Column(name="ADDRESS_LINE_2")
    public String addressLine2;

    @Column(name="CITY")
    public String city;

    @Column(name="PROVINCE")
    public String province;

    @Column(name="POSTAL_CODE")
    public String postalCode;

    @Column(name="COUNTRY")
    public String country;

    @Column(name="LAST_UPDATED_TIME")
    public Timestamp lastUpdatedTime;

    @Column(name="LAST_UPDATED_BY")
    public String lastUpdateBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BENE_ID", referencedColumnName = "BENE_ID")
    private AccountBene generalTrustBenes;

  /*  @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(  name = "ACCOUNT_BENE",
            joinColumns ={
                    @JoinColumn(name = "BENE_ID")},
            inverseJoinColumns ={
                    @JoinColumn(name = "ACCOUNT_ID")})
    private Account account;*/

   /* @OneToOne(cascade = CascadeType.ALL)
  //  @ManyToMany(mappedBy = "accountBenes")
    @JoinTable(  name = "ACCOUNT_BENE",
            joinColumns ={
                    @JoinColumn(name = "BENE_ID")},
            inverseJoinColumns ={
                    @JoinColumn(name = "ACCOUNT_ID")})
     AccountBene accountBenes;*/

  /*  public GeneralTrustBene(Character beneType, String entityName, String firstName, String lastName, String middleName, String addressLine1, String addressLine2, String city, String province, String postalCode, String country, Timestamp lastUpdatedTime, String lastUpdateBy, Account account) {
        this.beneType = beneType;
        this.entityName = entityName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
        this.lastUpdatedTime = lastUpdatedTime;
        this.lastUpdateBy = lastUpdateBy;
        this.account = account;
    }*/

    public GeneralTrustBene(Character beneType, String entityName, String firstName, String lastName, String middleName, String addressLine1, String addressLine2, String city, String province, String postalCode, String country, Timestamp lastUpdatedTime, String lastUpdateBy) {
        this.beneType = beneType;
        this.entityName = entityName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
        this.lastUpdatedTime = lastUpdatedTime;
        this.lastUpdateBy = lastUpdateBy;
    }
}
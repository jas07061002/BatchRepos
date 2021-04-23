package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
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

  /*  @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    private Account account;*/


}
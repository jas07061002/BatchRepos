package com.example.demo.model;

import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ObjectConverter {

    public Integer accountNum;
    public Integer branchNum;
    public Timestamp accountClosedDate;
    public String accountStatus;
    public String accountType;
    public String cdicTrustType;
    public List<GeneralTrustBene> generaltrustbene;
    public Integer per;



}

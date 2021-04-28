package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.AccountBene;
import com.example.demo.model.GeneralTrustBene;
import com.example.demo.model.ObjectConverter;
import com.example.demo.repository.AccountBeneRepository;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.BeneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BeneController {

    @Autowired
    BeneRepository beneRepository;

    @Autowired
    AccountBeneRepository accountBeneRepository;

    @Autowired
    AccountRepository accountRepository;

    @PostMapping(path = "/beneAndAccount")
    public String saveBeneAccount(@RequestBody ObjectConverter objectConverter) {
        Account account = new Account();
        account.accountNum = objectConverter.accountNum;
        account.accountClosedDate = objectConverter.accountClosedDate;
        account.accountType = objectConverter.accountType;
        account.branchNum = objectConverter.branchNum;
        account.cdicTrustType = objectConverter.cdicTrustType;
        List<GeneralTrustBene> generalTrustBeneList = new ArrayList<>(objectConverter.generaltrustbene);
        AccountBene accountBene = new AccountBene();
        account.setGeneralTrustBeneList(generalTrustBeneList);
       // generalTrustBeneList.forEach(generalTrustBene -> generalTrustBene.setAccount(account));
        accountBene.setAccount(account);
        accountBene.setGeneralTrustBenes(account.getGeneralTrustBeneList().get(0));
        accountBeneRepository.save(accountBene);

        return "success";

    }

    @GetMapping(path = "/beneinfo")
    public List<GeneralTrustBene> getBene(GeneralTrustBene generalTrustBene){
        return beneRepository.findAll();
    }
}

package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.AccountBene;
import com.example.demo.model.GeneralTrustBene;
import com.example.demo.model.ObjectConverter;
import com.example.demo.repository.AccountBeneRepository;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.BeneRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping(path = "/bat")
    public GeneralTrustBene saveController(@RequestBody GeneralTrustBene generalTrustBene) {
        AccountBene accountBene = new AccountBene();
        List<GeneralTrustBene> generalTrustBeneList = new ArrayList<>();
        generalTrustBeneList.add(generalTrustBene);
      //  accountBene.setGeneralTrustBene(generalTrustBeneList);
        // account.setAccountBene(accountBene);
        accountBeneRepository.save(accountBene);
        return generalTrustBene;

    }

    @PostMapping(path = "/bene")
    public GeneralTrustBene saveBene(@RequestBody GeneralTrustBene generalTrustBene) {
        Account account = new Account();
       // generalTrustBene.setAccount(account);
        AccountBene accountBene = new AccountBene();
        List<GeneralTrustBene> generalTrustBeneList = new ArrayList<>();
        generalTrustBeneList.add(generalTrustBene);
    //    accountBene.setGeneralTrustBene(generalTrustBeneList);
        // account.setAccountBene(accountBene);
        accountBeneRepository.save(accountBene);
        return generalTrustBene;

    }

    @PostMapping(path = "/beneAndAccount")
    public String saveBeneAccount(@RequestBody ObjectConverter objectConverter) {
        Account account = new Account();
        account.accountNum = objectConverter.accountNum;
        account.accountClosedDate = objectConverter.accountClosedDate;
        account.accountType = objectConverter.accountType;
        account.branchNum = objectConverter.branchNum;
        account.cdicTrustType = objectConverter.cdicTrustType;
        List<GeneralTrustBene> generalTrustBeneList = new ArrayList<>(objectConverter.generaltrustbene);
        for(int i=0;i<generalTrustBeneList.size();i++) {
      //      generalTrustBeneList.get(i).setAccount(account);
        }
        AccountBene accountBene = new AccountBene();
        accountBene.setGeneralTrustBenes(generalTrustBeneList.get(0));
        accountBene.setAccount(account);
        // account.setAccountBene(accountBene);
       // account.setGeneralTrustBeneList(generalTrustBeneList);
        accountBeneRepository.save(accountBene);
     //  beneRepository.saveAll(generalTrustBeneList);
      //  accountBeneRepository.save(accountBene);
        return "success";

    }
}

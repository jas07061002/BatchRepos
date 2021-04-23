package com.example.demo.controller;


import com.example.demo.model.Account;
import com.example.demo.model.AccountBene;
import com.example.demo.repository.AccountBeneRepository;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountBeneRepository accountBeneRepository;


    @PostMapping(path = "/batches")
    public Account saveController(@RequestBody Account account) {
        AccountBene accountBene = new AccountBene();
     //    accountBene.setAccount(account);
       // account.setAccountBene(accountBene);
        accountBeneRepository.save(accountBene);
        return account;

    }
}

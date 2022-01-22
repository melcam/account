package com.nttdata.bootcamp.account.business.impl;

import com.nttdata.bootcamp.account.business.AccountService;
import com.nttdata.bootcamp.account.model.Account;
import com.nttdata.bootcamp.account.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private WebClient webClient;

  @Override
  public Mono<Account> create(Account account) {
    if (!account.getNumberaccount().isBlank() && account.getAccounttype().getType().equals("cuenta de ahorro")) {
      account.setNumberaccount("123456789");
      // account.setDate(java.sql.Date sql = new java.sql.Date(parsed.getTime()));
      account.setBalance(0.00);
      accountRepository.save(account);
    }
    return accountRepository.save(account);
  }
}

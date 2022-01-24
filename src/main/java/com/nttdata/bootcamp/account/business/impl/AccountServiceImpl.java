package com.nttdata.bootcamp.account.business.impl;

import java.util.Random;

import com.nttdata.bootcamp.account.business.AccountService;
import com.nttdata.bootcamp.account.model.Account;
import com.nttdata.bootcamp.account.model.Accounttype;
import com.nttdata.bootcamp.account.model.Banckaccount;
import com.nttdata.bootcamp.account.model.dto.AccountDTO;
import com.nttdata.bootcamp.account.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private WebClient webClient;

  @Override
  public Mono<Account> create(Account account) {
    log.info("Start to create");
    if (!account.getType().isBlank()) {
      return webClient.get()
          .uri(uriBuilder -> uriBuilder
              .queryParam("type", account.getType())
              .build())
          .retrieve().bodyToFlux(AccountDTO.class)
          .next().flatMap(at -> {
            Banckaccount banckaccount = new Banckaccount();
            Accounttype accounttype = new Accounttype();
            Random random = new Random();
            if (at.getType().equals("cuenta de ahorro")) {
              banckaccount.setMaintenance(0.00);
              banckaccount.setLimit(2.00);

              accounttype.setType("cuenta de ahorro");
            }
            if (at.getType().equals("cuenta de corriente")) {
              banckaccount.setMaintenance(9.00);
              banckaccount.setLimit(null);

              accounttype.setType("cuenta de corriente");
            }
            if (at.getType().equals("cuenta de plazo fijo")) {
              banckaccount.setMaintenance(0.00);
              banckaccount.setLimit(5.00);

              accounttype.setType("cuenta de plazo fijo");
            }

            account.setBanckaccount(banckaccount);
            account.setAccounttype(accounttype);
            account.setNumberaccount(Long.toString(random.nextLong()));
            account.setBalance(0.00);

            return accountRepository.save(account);
          });
    }

    return accountRepository.save(account);
  }

  @Override
  public Mono<Account> findById(String id) {
    return accountRepository.findById(id);
  }

  @Override
  public Flux<Account> findAll() {
    return accountRepository.findAll();
  }
}

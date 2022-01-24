package com.nttdata.bootcamp.account.business;

import com.nttdata.bootcamp.account.model.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
  Mono<Account> create(Account account);

  Mono<Account> findById(String Id);

  Flux<Account> findAll();
}

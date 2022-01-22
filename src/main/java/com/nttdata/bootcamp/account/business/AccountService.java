package com.nttdata.bootcamp.account.business;

import com.nttdata.bootcamp.account.model.Account;

import reactor.core.publisher.Mono;

public interface AccountService {
  Mono<Account> create(Account account);
}

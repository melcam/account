package com.nttdata.bootcamp.account.expose;

import com.nttdata.bootcamp.account.business.AccountService;
import com.nttdata.bootcamp.account.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class AccountController {

  @Autowired
  private AccountService accountService;

  @PostMapping("/api/accounts")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Account> create(@RequestBody Account account) {
    log.info("<--create-->");
    return accountService.create(account);
  }
}

package com.nttdata.bootcamp.account.expose;

import com.nttdata.bootcamp.account.business.AccountService;
import com.nttdata.bootcamp.account.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
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

  @GetMapping("/api/accounts/{id}")
  public Mono<Account> findById(@PathVariable("id") String id) {
    log.info("<--findById-->");
    return accountService.findById(id);
  }

  @GetMapping("/api/accounts")
  public Flux<Account> findAll() {
    log.info("<--findAll-->");
    return accountService.findAll();
  }
}

package com.nttdata.bootcamp.account.repository;

import com.nttdata.bootcamp.account.model.Account;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {

}

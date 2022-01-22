package com.nttdata.bootcamp.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class AccountAplication {
  public static void main(String[] args) {
    SpringApplication.run(AccountAplication.class, args);
  }
}

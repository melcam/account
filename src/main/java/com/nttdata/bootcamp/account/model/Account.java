package com.nttdata.bootcamp.account.model;

import java.sql.Date;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "account")
public class Account {
  
  @Id
  private String id = UUID.randomUUID().toString();
  private String numberaccount;
  private Date date;
  private Double balance;
  private Accounttype accounttype;
}

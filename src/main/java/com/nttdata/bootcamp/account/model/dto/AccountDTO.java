package com.nttdata.bootcamp.account.model.dto;

import java.sql.Date;
import com.nttdata.bootcamp.account.model.Accounttype;
import com.nttdata.bootcamp.account.model.Banckaccount;

import lombok.Data;

@Data
public class AccountDTO {
  private String id;
  private String numberaccount;
  private String type;
  private Date date;
  private Double balance;
  private Accounttype accounttype;
  private Banckaccount banckaccount;
}

package com.nttdata.bootcamp.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Accounttype {
  private String id;
  private String type;
  private Boolean status;
}

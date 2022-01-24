package com.nttdata.bootcamp.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "banckaccount")
public class Banckaccount {

    @Id
    private String id = UUID.randomUUID().toString();
    private Double maintenance;
    private Double limit;
    private Boolean status;
    private String description;
}

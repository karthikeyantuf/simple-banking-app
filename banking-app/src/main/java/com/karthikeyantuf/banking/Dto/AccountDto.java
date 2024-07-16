package com.karthikeyantuf.banking.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long Id;
    private String accountHolderName;
    private Double balance;
}

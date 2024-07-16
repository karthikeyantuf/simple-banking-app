package com.karthikeyantuf.banking.service;

import com.karthikeyantuf.banking.Dto.AccountDto;

import java.util.List;

public interface AccountService {

        AccountDto createAccount(AccountDto accountDto);

        AccountDto getAccountById(Long id);

        AccountDto deposit(Long id , Double amount);

        AccountDto withdraw(Long id , Double amount);

        List<AccountDto> getAllAccounts();

        void deleteAccountById(Long id);
}

package com.karthikeyantuf.banking.service.impl;

import com.karthikeyantuf.banking.Dto.AccountDto;
import com.karthikeyantuf.banking.entity.Account;
import com.karthikeyantuf.banking.mapper.AccountMapper;
import com.karthikeyantuf.banking.repository.AccountRepository;
import com.karthikeyantuf.banking.service.AccountService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto)
    {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id)
    {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
        return  AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not exists"));
        account.setBalance(account.getBalance()+amount);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto withdraw(Long id, Double amount) {
       Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exists"));

       if(account.getBalance() < amount)
       {
           throw new RuntimeException("Insufficient balance");
       }

       account.setBalance(account.getBalance() - amount);
       Account savedAccount = accountRepository.save(account);
       return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDto> accountDtos = accounts.stream().map((account -> AccountMapper.mapToAccountDto(account))).collect(Collectors.toList());
        return accountDtos;
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }


}

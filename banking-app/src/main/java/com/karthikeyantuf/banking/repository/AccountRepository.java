package com.karthikeyantuf.banking.repository;

import com.karthikeyantuf.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}

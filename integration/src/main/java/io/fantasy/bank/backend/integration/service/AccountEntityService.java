package io.fantasy.bank.backend.integration.service;

import io.fantasy.bank.backend.integration.entity.Account;
import io.fantasy.bank.backend.integration.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountEntityService {
    AccountRepository repository;

    public AccountEntityService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account getAccountById(int id) {
        return repository.findById(id).get();
    }

    public void saveOrUpdate(Account account) {
        repository.save(account);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}


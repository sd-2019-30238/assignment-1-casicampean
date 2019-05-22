package application.service;


import application.model.Account;
import application.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void updateAccountType(Integer id, String payment){
        Account account = accountRepository.getOne(id);
        account.setPayment(payment);
    }

    public void printAccounts(){
        List<Account>accounts = accountRepository.findAll();

        for(Account account : accounts){
            System.out.println(account);
        }
    }

    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccount(Integer id){
        return accountRepository.getOne(id);

    }

    public void addAccount(String username, String password, String type) {

        Account account = new Account(username, password, type);

        if (type.equals("staff")) {
            account.setPayment("free");
        }

        accountRepository.save(account);
    }

    public void deleteAccount(Integer id){
        accountRepository.deleteById(id);
    }

    public boolean existsAccount(Integer id){
        return accountRepository.existsById(id);
    }
}

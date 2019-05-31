package application.controller;

import application.model.Account;
import application.model.dto.AccountCommandDTO;
import application.model.dto.AccountConverter;
import application.repository.AccountRepository;
import application.service.IAccountCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountCommandController {

    private final AccountRepository accountRepository;


    public AccountCommandController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("/accounts") //COMMAND
    public void addAccount(@RequestBody AccountCommandDTO accountCommandDTO) {
        Account account = AccountConverter.convertDTOtoAccount(accountCommandDTO);
        accountRepository.save(account);
    }


    @DeleteMapping(path = { "/{id}" })
    public Account delete(@PathVariable("id") int id) {
        Account deletedAcc = null;
        List<Account> accountList = accountRepository.findAll();
        for (Account account : accountList) {
            if (account.getType().equals(id)) {
                accountList.remove(account);
                deletedAcc = account;
                break;
            }
        }
        return deletedAcc;
    }


}

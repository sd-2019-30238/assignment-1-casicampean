package application.controller;


import application.model.Account;
import application.model.dto.AccountConverter;
import application.model.dto.AccountLoginDTO;
import application.repository.AccountRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private final AccountRepository accountRepository;

    public LoginController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @PostMapping(value = "/login", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Integer checkValid(@RequestBody AccountLoginDTO accountLoginDTO) {
        List<Account> accountList = accountRepository.findAll();

        String username = accountLoginDTO.getUsername();
        String password = accountLoginDTO.getPassword();

        for (Account account1 : accountList) {
            if (account1.getUsername().equals(username) && account1.getPassword().equals(password)) {
                if (account1.getType().equals("staff")) {
                    return 1;//this account is a staff account
                }
                return 2;//this account is a user account
            }
        }
        return 0;
    }

    @PostMapping(value = "/getAccount", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public AccountLoginDTO getAccount(@RequestBody Account account) {

        List<Account> accountList = accountRepository.findAll();

        for (Account account1 : accountList) {
            if (account1.getUsername().equals(account.getUsername())) {

                return AccountConverter.convertAccountToLoginDTO(account1);//if I find a the right account in the DB I return it
            }
        }

        return AccountConverter.convertAccountToLoginDTO(account);
    }
}





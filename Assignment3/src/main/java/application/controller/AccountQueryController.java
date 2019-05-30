package application.controller;

import application.model.Account;
import application.model.dto.AccountConverter;
import application.model.dto.AccountQueryDTO;
import application.repository.AccountRepository;
import application.service.IAccountQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountQueryController {

    private AccountConverter accountConverter;

    private final AccountRepository accountRepository;


    public AccountQueryController( AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts") //QUERY
    public List<AccountQueryDTO> getAccounts(){
        List<Account> accountList = accountRepository.findAll();
        List<AccountQueryDTO>accountQueryDTOS = new ArrayList<>();
        for(Account account: accountList){
            AccountQueryDTO accountQueryDTO = AccountConverter.convertAccountToDTO(account);
            accountQueryDTOS.add(accountQueryDTO);
        }
        return accountQueryDTOS;
    }

    @PostMapping("/getaccount") //QUERY
    public AccountQueryDTO getAccount(Account account){
        Optional<Account> loggedAccount = accountRepository.findById(account.getId());

        if (loggedAccount.isPresent()){
            return AccountConverter.convertAccountToDTO(loggedAccount.get()) ;
        }
        return AccountConverter.convertAccountToDTO(account);
    }



}

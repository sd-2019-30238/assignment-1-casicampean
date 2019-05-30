package application.service;

import application.model.Account;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface IAccountQueryService {

    //getAcc
     List<Account> getAccounts();
     Account getAccount(Account account);

}

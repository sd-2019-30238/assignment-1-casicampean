package application.service;

import application.model.Account;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAccountCommandService {

    //addAcc
    //updateAcc
    void addAccount(@RequestBody Account account);
}

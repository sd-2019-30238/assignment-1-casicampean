package application.model.dto;

import application.model.Account;

import java.util.HashSet;

public class AccountConverter {


    public static Account convertDTOtoAccount(AccountCommandDTO accountQueryDTO) {
        final Account entity = new Account();

        entity.setUsername(accountQueryDTO.getUsername());
        entity.setPayment(accountQueryDTO.getPayment());
        entity.setPassword(accountQueryDTO.getPassword());
        entity.setType(accountQueryDTO.getType());

        return entity;
    }

    public static AccountQueryDTO convertAccountToDTO(Account account){

        final AccountQueryDTO accountQueryDTO = new AccountQueryDTO();

        accountQueryDTO.setPassword(account.getPassword());
        accountQueryDTO.setUsername(account.getUsername());
        accountQueryDTO.setPayment(account.getPayment());
        accountQueryDTO.setId(account.getId());

        return accountQueryDTO;
    }

    public static AccountLoginDTO convertAccountToLoginDTO(Account account){

        final AccountLoginDTO accountLoginDTO = new AccountLoginDTO();

        accountLoginDTO.setPassword(account.getPassword());
        accountLoginDTO.setUsername(account.getUsername());


        return accountLoginDTO;

    }
}

package dataAccess;

import models.Account;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AccountAccessTest {



    @Test
    public void addAccount() {
        AccountAccess accountAccess = new AccountAccess();
        //accountAccess.addAccount("mara","mara","user");
        ArrayList<Account> accounts = accountAccess.queryRegister("mara");
        assertEquals(1,accounts.size());
    }



    @Test
    public void readAccount() {
        AccountAccess accountAccess = new AccountAccess();
        Account account = accountAccess.readAccount(1);
        assertEquals("casi",account.getUsername());
    }

    @Test
    public void updateAccount() {
        AccountAccess accountAccess = new AccountAccess();
        accountAccess.updateAccount(20,"1 month");
        Account account = accountAccess.readAccount(20);
        assertEquals("1 month",account.getPayment());
    }

    @Test
    public void deleteAccount() {
        AccountAccess accountAccess =  new AccountAccess();
        //accountAccess.addAccount("a","b","user");
        accountAccess.deleteAccount(23);
        ArrayList<Account>accounts = accountAccess.queryRegister("a");
        assertEquals(0, accounts.size());
    }
}
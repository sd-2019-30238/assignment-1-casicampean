package bussinessLogic;

import dataAccess.AccountAccess;
import models.Account;
import models.Book;

public class Staff  {
    private int id;
    private String username;
    private String password;
    private Account account;
    private AccountAccess accountAccess;
    private Library library;


    public void validatePayment(){

    }
    public void validateReturn(){

    }
    public void createAccount(){
        accountAccess.addAccount(this.username,this.password,"staff");
        library.addStaff(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}

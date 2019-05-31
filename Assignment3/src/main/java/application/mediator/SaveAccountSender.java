package application.mediator;

import application.controller.AccountCommandController;
import application.model.dto.AccountCommandDTO;

public class SaveAccountSender implements Sender
{
    AccountCommandController accountCommandController;
    AccountCommandDTO accountCommandDTO;

    @Override
    public void send(String request) {
        accountCommandController.addAccount(accountCommandDTO);
    }

    @Override
    public String getRequest() {
        return "save account";
    }
}

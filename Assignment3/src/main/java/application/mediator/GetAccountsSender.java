package application.mediator;

import application.controller.AccountQueryController;
import application.model.dto.AccountQueryDTO;

public class GetAccountsSender implements Sender {
    AccountQueryController accountQueryController;

    @Override
    public void send(String request) {
        accountQueryController.getAccounts();

    }

    @Override
    public String getRequest() {
        return "get accounts";
    }
}

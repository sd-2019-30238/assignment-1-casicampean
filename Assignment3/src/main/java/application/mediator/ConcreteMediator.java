package application.mediator;

import java.util.ArrayList;

public class ConcreteMediator implements Mediator{

    public ConcreteMediator(ArrayList<Sender> senders) {
        this.senders = senders;
    }

    ArrayList<Sender>senders;

    public void addSender(Sender sender){
        senders.add(sender);
    }


    @Override
    public void makeRequest(Sender sender, String request) {
        for(Sender sender1: senders){
            if(sender.getRequest().equals(request)){
                sender.send(request);
            }
        }

    }
}

package application.mediator;

public interface Sender {
    void send(String request);
    String getRequest();

}

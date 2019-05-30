package application.model.dto;

public class AccountQueryDTO {

    private int id;
    private String username;
    private String password;
    private String type;
    private String payment;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getPayment() {
        return payment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}

package application.model;




import javax.persistence.*;

@Entity
//@Table
public class Account  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String type;
    private String payment;


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }


    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Account() {

    }

    public Account(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;

    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
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

    public String getPayment() {
        return payment;
    }

}




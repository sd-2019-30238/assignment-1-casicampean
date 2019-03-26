package bussinessLogic;

public class PaymentPlan {
    private String type;
    private int price;

    public PaymentPlan(String plan){
        if(plan.equals("1 month"))
        {
            this.type = "1 month";
            this.price = 15;
        }
        if(plan.equals("6 months"))
        {
            this.type = "6 months";
            this.price = 75;
        }
        if(plan.equals("1 year"))
        {
            this.type = "1 year";
            this.price = 120;
        }
        if(plan.equals("staff"))
        {
            this.type = "staff";
            this.price = 0;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




}

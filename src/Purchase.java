import java.util.Date;

public class Purchase {
    private String id;
    private String buyer;
    private Date date;
    private int quantity;
    private double totalPrice;

    public Purchase(String id, String buyer, Date date, int quantity, double totalPrice) {
        this.id = id;
        this.buyer = buyer;
        this.date = date;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters and setters

    public String getId() {
        return id;
    }
    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

//    public String getDate() {
//        return date;
//    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "buyer='" + buyer + '\'' +
                ", date=" + date +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
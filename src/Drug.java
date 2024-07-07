import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Date;

public class Drug {
    private String drugCode;
    private String name;
    private String description;
    private List<Supplier> suppliers;
    private int stockLevel;
    private double price;
    private PriorityQueue<Purchase> purchaseHistory;

    public Drug(String drugCode, String name, String description, double price) {
        this.drugCode = drugCode;
        this.name = name;
        this.description = description;
        this.price = price;
        this.suppliers = new ArrayList<>();
        this.stockLevel = 0;
       // this.purchaseHistory = new PriorityQueue<>((p1, p2) -> p1.getDate().compareTo(p2.getDate()));
    }

    // Getters and setters
    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void addSupplier(Supplier supplier) {
        this.suppliers.add(supplier);
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PriorityQueue<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void addPurchase(Purchase purchase) {
        this.purchaseHistory.add(purchase);
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugCode='" + drugCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stockLevel=" + stockLevel +
                ", price=" + price +
                '}';
    }
}
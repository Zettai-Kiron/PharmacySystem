import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PharmacyManagementSystem {
    private Map<String, Drug> drugCollection = new HashMap<>();
    private Map<String, Supplier> supplierCollection = new HashMap<>();
    private Map<String, Purchase> purchaseCollection = new HashMap<>();
    private DatabaseManager dbManager;

    public PharmacyManagementSystem(String dbURL, String user, String password) throws SQLException {
        this.dbManager = new DatabaseManager(dbURL, user, password);
    }

    // Methods to add, remove, search drugs
    public void addDrug(Drug drug) {
        drugCollection.put(drug.getDrugCode(), drug);
        dbManager.addDrugToDatabase(drug);
    }

    public void removeDrug(String drugCode) {
        drugCollection.remove(drugCode);
        dbManager.removeDrugFromDatabase(drugCode);
    }

    public Drug searchDrug(String drugCode) {
        return drugCollection.get(drugCode);
    }

    // Method to view all drugs
    public void viewAllDrugs() {
        for (Drug drug : drugCollection.values()) {
            System.out.println(drug);
        }
    }

    // Method to view purchase history
    public void viewPurchaseHistory(String drugCode) {
        Drug drug = drugCollection.get(drugCode);
        if (drug != null) {
            for (Purchase purchase : drug.getPurchaseHistory()) {
                System.out.println(purchase);
            }
        }
    }

    // Methods to add, remove, search suppliers
    public void addSupplier(Supplier supplier) {
        supplierCollection.put(supplier.getId(), supplier);
        dbManager.addSupplierToDatabase(supplier);
    }

    public void removeSupplier(String supplierId) {
        supplierCollection.remove(supplierId);
        dbManager.removeSupplierFromDatabase(supplierId);
    }

    public Supplier searchSupplier(String supplierId) {
        return supplierCollection.get(supplierId);
    }

    // Methods to add, remove, search purchases
    public void addPurchase(Purchase purchase) {
        purchaseCollection.put(purchase.getId(), purchase);
        dbManager.addPurchaseToDatabase(purchase);
    }

    public void removePurchase(String purchaseId) {
        purchaseCollection.remove(purchaseId);
        dbManager.removePurchaseFromDatabase(purchaseId);
    }

    public Purchase searchPurchase(String purchaseId) {
        return purchaseCollection.get(purchaseId);
    }


}

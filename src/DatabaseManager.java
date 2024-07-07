import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager(String dbURL, String user, String password) throws SQLException {
        try {
            connection = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException e) {
            throw new SQLException("Failed to connect to the database", e);
        }
    }

    // Methods for Drugs
    public void addDrugToDatabase(Drug drug) {
        String query = "INSERT INTO drugs (code, name, description, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, drug.getDrugCode());
            stmt.setString(2, drug.getName());
            stmt.setString(3, drug.getDescription());
            stmt.setDouble(4, drug.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeDrugFromDatabase(String drugCode) {
        String query = "DELETE FROM drugs WHERE code = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, drugCode);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSupplierToDatabase(Supplier supplier) {
        String query = "INSERT INTO suppliers (id, name, contact) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, supplier.getId());
            stmt.setString(2, supplier.getName());
            stmt.setString(3, supplier.getContactInfo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeSupplierFromDatabase(String supplierId) {
        String query = "DELETE FROM suppliers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, supplierId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPurchaseToDatabase(Purchase purchase) {
        String query = "INSERT INTO purchases (id, buyer, quantity, date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, purchase.getId());
            stmt.setString(3, purchase.getBuyer());
            stmt.setInt(4, purchase.getQuantity());
            //stmt.setDate(5, Date.valueOf(purchase.getDate()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePurchaseFromDatabase(String purchaseId) {
        String query = "DELETE FROM purchases WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, purchaseId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

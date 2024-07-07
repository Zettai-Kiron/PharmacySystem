import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.SQLException;


public class PharmacyUI extends Application {
    private PharmacyManagementSystem system;

    @Override
    public void start(Stage primaryStage) {
        try {
            system = new PharmacyManagementSystem("jdbc:mysql://localhost:3306/PharmacyDB", "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);

        // Create UI components for adding drugs
        TextField drugCodeField = new TextField();
        TextField drugNameField = new TextField();
        TextField drugDescriptionField = new TextField();
        TextField drugPriceField = new TextField();

        Button addButton = new Button("Add Drug");
        addButton.setOnAction(e -> {
            String code = drugCodeField.getText();
            String name = drugNameField.getText();
            String description = drugDescriptionField.getText();
            double price = Double.parseDouble(drugPriceField.getText());
            Drug drug = new Drug(code, name, description, price);
            system.addDrug(drug);
        });

        // Create UI components for removing drugs
        TextField removeDrugCodeField = new TextField();
        Button removeButton = new Button("Remove Drug");
        removeButton.setOnAction(e -> {
            String code = removeDrugCodeField.getText();
            system.removeDrug(code);
        });

        // Create UI components for searching drugs
        TextField searchDrugCodeField = new TextField();
        TextArea searchResultArea = new TextArea();
        searchResultArea.setEditable(false);
        Button searchButton = new Button("Search Drug");
        searchButton.setOnAction(e -> {
            String code = searchDrugCodeField.getText();
            Drug drug = system.searchDrug(code);
            if (drug != null) {
                searchResultArea.setText("Code: " + drug.getDrugCode() + "\n"
                        + "Name: " + drug.getName() + "\n"
                        + "Description: " + drug.getDescription() + "\n"
                        + "Price: " + drug.getPrice());
            } else {
                searchResultArea.setText("Drug not found.");
            }
        });

        VBox addDrugBox = new VBox(
                new Label("Add Drug"),
                new Label("Drug Code:"), drugCodeField,
                new Label("Drug Name:"), drugNameField,
                new Label("Description:"), drugDescriptionField,
                new Label("Price:"), drugPriceField,
                addButton
        );

        VBox removeDrugBox = new VBox(
                new Label("Remove Drug"),
                new Label("Drug Code:"), removeDrugCodeField,
                removeButton
        );

        VBox searchDrugBox = new VBox(
                new Label("Search Drug"),
                new Label("Drug Code:"), searchDrugCodeField,
                searchButton,
                new Label("Search Result:"), searchResultArea
        );

        VBox mainBox = new VBox(addDrugBox, removeDrugBox, searchDrugBox);
        mainBox.setSpacing(20);

        root.setCenter(mainBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Pharmacy Management System");
        primaryStage.show();
    }

    public static void launch(String[] args) {
        launch(args);
    }
}

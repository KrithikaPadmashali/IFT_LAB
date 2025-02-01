package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class bank extends Application {
    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();
        
        Tab customerTab = new Tab("Customer", createCustomerPane());
        Tab creditTab = new Tab("Credit", createCreditPane());
        Tab debitTab = new Tab("Debit", createDebitPane());
        
        customerTab.setClosable(false);
        creditTab.setClosable(false);
        debitTab.setClosable(false);
        
        tabPane.getTabs().addAll(customerTab, creditTab, debitTab);
        
        Scene scene = new Scene(tabPane, 600, 400);
        primaryStage.setTitle("Banking System GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private VBox createCustomerPane() {
        VBox vbox = new VBox(10);
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        TextField email = new TextField();
        TextField phone = new TextField();
        TextField address = new TextField();
        Button addButton = new Button("Add Customer");
        
        vbox.getChildren().addAll(
            new Label("First Name"), firstName,
            new Label("Last Name"), lastName,
            new Label("Email"), email,
            new Label("Phone No"), phone,
            new Label("Address"), address,
            addButton
        );
        return vbox;
    }
    
    private VBox createCreditPane() {
        VBox vbox = new VBox(10);
        TextField customerId = new TextField();
        TextField amount = new TextField();
        Button creditButton = new Button("Add Credit");
        
        vbox.getChildren().addAll(
            new Label("Customer ID"), customerId,
            new Label("Amount"), amount,
            creditButton
        );
        return vbox;
    }
    
    private VBox createDebitPane() {
        VBox vbox = new VBox(10);
        TextField customerId = new TextField();
        TextField amount = new TextField();
        Button debitButton = new Button("Add Debit");
        
        vbox.getChildren().addAll(
            new Label("Customer ID"), customerId,
            new Label("Amount"), amount,
            debitButton
        );
        return vbox;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

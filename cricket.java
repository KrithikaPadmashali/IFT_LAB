package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class cricket extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cricket Management");

        TabPane tabPane = new TabPane();
        
        // Player Tab
        Tab playerTab = new Tab("Player");
        playerTab.setContent(createPlayerForm());
        playerTab.setClosable(false);

        // Stadium Tab
        Tab stadiumTab = new Tab("Stadium");
        stadiumTab.setContent(createStadiumForm());
        stadiumTab.setClosable(false);

        // Bowler Tab
        Tab bowlerTab = new Tab("Bowler");
        bowlerTab.setContent(createBowlerForm());
        bowlerTab.setClosable(false);

        // Batter Tab
        Tab batterTab = new Tab("Batter");
        batterTab.setContent(createBatterForm());
        batterTab.setClosable(false);

        tabPane.getTabs().addAll(playerTab, stadiumTab, bowlerTab, batterTab);

        VBox root = new VBox(tabPane);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createPlayerForm() {
        GridPane grid = createGrid();
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        DatePicker dob = new DatePicker();
        TextField nationality = new TextField();
        TextField role = new TextField();
        Button addButton = new Button("Add Player");

        grid.add(new Label("First Name:"), 0, 0);
        grid.add(firstName, 1, 0);
        grid.add(new Label("Last Name:"), 0, 1);
        grid.add(lastName, 1, 1);
        grid.add(new Label("DOB:"), 0, 2);
        grid.add(dob, 1, 2);
        grid.add(new Label("Nationality:"), 0, 3);
        grid.add(nationality, 1, 3);
        grid.add(new Label("Role:"), 0, 4);
        grid.add(role, 1, 4);
        grid.add(addButton, 1, 5);

        return grid;
    }

    private GridPane createStadiumForm() {
        GridPane grid = createGrid();
        TextField stadiumName = new TextField();
        TextField location = new TextField();
        TextField capacity = new TextField();
        Button addButton = new Button("Add Stadium");

        grid.add(new Label("Stadium Name:"), 0, 0);
        grid.add(stadiumName, 1, 0);
        grid.add(new Label("Location:"), 0, 1);
        grid.add(location, 1, 1);
        grid.add(new Label("Capacity:"), 0, 2);
        grid.add(capacity, 1, 2);
        grid.add(addButton, 1, 3);

        return grid;
    }

    private GridPane createBowlerForm() {
        GridPane grid = createGrid();
        TextField playerId = new TextField();
        TextField matches = new TextField();
        TextField wickets = new TextField();
        TextField economyRate = new TextField();
        TextField bowlingAvg = new TextField();
        Button addButton = new Button("Add Bowler");

        grid.add(new Label("Player ID:"), 0, 0);
        grid.add(playerId, 1, 0);
        grid.add(new Label("Matches:"), 0, 1);
        grid.add(matches, 1, 1);
        grid.add(new Label("Wickets:"), 0, 2);
        grid.add(wickets, 1, 2);
        grid.add(new Label("Economy Rate:"), 0, 3);
        grid.add(economyRate, 1, 3);
        grid.add(new Label("Bowling Avg:"), 0, 4);
        grid.add(bowlingAvg, 1, 4);
        grid.add(addButton, 1, 5);

        return grid;
    }

    private GridPane createBatterForm() {
        GridPane grid = createGrid();
        TextField playerId = new TextField();
        TextField matches = new TextField();
        TextField strikes = new TextField();
        TextField strikeRate = new TextField();
        TextField battingAvg = new TextField();
        Button addButton = new Button("Add Batter");

        grid.add(new Label("Player ID:"), 0, 0);
        grid.add(playerId, 1, 0);
        grid.add(new Label("Matches:"), 0, 1);
        grid.add(matches, 1, 1);
        grid.add(new Label("Strikes:"), 0, 2);
        grid.add(strikes, 1, 2);
        grid.add(new Label("Strike Rate:"), 0, 3);
        grid.add(strikeRate, 1, 3);
        grid.add(new Label("Batting Avg:"), 0, 4);
        grid.add(battingAvg, 1, 4);
        grid.add(addButton, 1, 5);

        return grid;
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        return grid;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Label homeTxt = new Label();
        homeTxt.setText("Hello Rawand, Welcome back!!");
        homeTxt.setFont(new Font("Arial\"",15));

        //main screen buttons
        Button expensesBut = new Button();
        Button savingsBut = new Button();
        Button incomeBut = new Button();

        expensesBut.setText("Expenses");
        savingsBut.setText("Savings");
        incomeBut.setText("Income");

        savingsBut.setTranslateX(150);
        savingsBut.setTranslateY(60);
        expensesBut.setTranslateY(60);
        expensesBut.setTranslateX(80);
        incomeBut.setTranslateY(60);
        incomeBut.setTranslateX(210);

        //Setting the stage
        Group root = new Group(savingsBut,homeTxt,expensesBut,incomeBut);
        Scene mainScene = new Scene(root, 300, 250, Color.AQUAMARINE);


        //Expenses scene
        Label expensesLabel= new Label("This is the Expenses");
        Button homeBut= new Button("Home");
        homeBut.setOnAction(e -> stage.setScene(mainScene));
        VBox expenseLayout= new VBox(20);
        expenseLayout.getChildren().addAll(expensesLabel, homeBut);
        Scene expenseScene= new Scene(expenseLayout,300,250);

        expensesBut.setOnAction(e -> stage.setScene(expenseScene));

        //savings scene
        Label savingsLabel = new Label("This is the savings scene");
        Button homeBut1 = new Button("Home");
        homeBut1.setOnAction(e -> stage.setScene(mainScene));
        VBox savingsLayout = new VBox(20);
        savingsLayout.getChildren().addAll(savingsLabel,homeBut1);

        Scene savingScene = new Scene(savingsLayout,300,250);

        savingsBut.setOnAction(e -> stage.setScene(savingScene));

        // Income scene

        Label incomeLabel = new Label("This is the income scene");
        Button homeBut4 = new Button("Home");
        homeBut4.setOnAction(e -> stage.setScene(mainScene));
        VBox incomeLayout = new VBox(20);
        incomeLayout.getChildren().addAll(incomeLabel,homeBut4);

        Scene incomeScene = new Scene(incomeLayout,300,250);

        incomeBut.setOnAction(event -> stage.setScene(incomeScene));

        stage.setTitle("Savings Manager");
        stage.setScene(mainScene);


        stage.show();




    }

    public static void main(String[] args) {
        launch(args);
    }

}



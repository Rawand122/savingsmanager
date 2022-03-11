package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        double [] initialValues = getLastValues();

        Expenses expenses = Expenses.getInstance();
        Savings savings = Savings.getInstance();
        Income income = Income.getInstance();
        expenses.addExpenses(initialValues[0]);
        savings.addSavings(initialValues[1]);
        income.addIncome(initialValues[2]);

        Label homeTxt = new Label();
        homeTxt.setText("Hello Rawand, Welcome back!!");
        homeTxt.setFont(new Font("Arial\"",15));

        //main screen buttons
        Button expensesBut = new Button();
        Button savingsBut = new Button();
        Button incomeBut = new Button();
        Button saveBut = new Button();

        expensesBut.setText("Expenses");
        savingsBut.setText("Savings");
        incomeBut.setText("Income");
        saveBut.setText("Save Data");

        //Setting the stage
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.getChildren().addAll(homeTxt,savingsBut,expensesBut,incomeBut,saveBut);

        saveBut.setOnAction(event -> {
            try {
                saveData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Scene mainScene = new Scene(mainLayout, 300, 250);


        //Expenses scene
        Label expensesLabel= new Label("This is the Expenses");
        Label currentExpenses = new Label("Current expenses: " +expenses.getExpenses());
        Label addExpensesLabel= new Label("Add an Expense: ");
        TextField textField = new TextField();
        Button addExpenseBut= new Button("Add Expense");
        addExpenseBut.setOnAction(event ->{
                    expenses.addExpenses(Double.parseDouble(textField.getText()));
                   currentExpenses.setText("Current expenses: " +expenses.getExpenses());
        } );
        Button homeBut= new Button("Home");
        homeBut.setOnAction(e -> stage.setScene(mainScene));
        VBox expenseLayout= new VBox(20);
        expenseLayout.getChildren().addAll(expensesLabel,currentExpenses,addExpensesLabel, textField,addExpenseBut,
                homeBut);
        Scene expenseScene= new Scene(expenseLayout,300,250);

        expensesBut.setOnAction(e -> stage.setScene(expenseScene));

        //savings scene
        Label savingsLabel = new Label("This is the savings scene");
        Label currentSavings = new Label("Current savings: "+ savings.getSavings());
        Label addSavingsLabel = new Label("Add Saving: ");
        TextField textField1 = new TextField();
        Button addSavingsBut = new Button("Add Saving");
        addSavingsBut.setOnAction(event -> {
            savings.addSavings(Double.parseDouble(textField1.getText()));
            currentSavings.setText("Current savings: " +savings.getSavings());
        } );
        Button homeBut1 = new Button("Home");
        homeBut1.setOnAction(e -> stage.setScene(mainScene));
        VBox savingsLayout = new VBox(20);
        savingsLayout.getChildren().addAll(savingsLabel,currentSavings,addSavingsLabel,textField1,addSavingsBut,homeBut1);

        Scene savingScene = new Scene(savingsLayout,300,250);

        savingsBut.setOnAction(e -> stage.setScene(savingScene));

        // Income scene

        Label incomeLabel = new Label("This is the income scene");
        Label currentIncome = new Label("Current income: "+ income.getIncome());
        Label addIncomeLabel = new Label("Add Income: ");
        TextField textField2 = new TextField();
        Button addIncomeBut = new Button("Add Income");
        addIncomeBut.setOnAction(event -> {
            income.addIncome(Double.parseDouble(textField2.getText()));
            currentIncome.setText("Current income: " +income.getIncome());
        } );
        Button homeBut4 = new Button("Home");
        homeBut4.setOnAction(e -> stage.setScene(mainScene));
        VBox incomeLayout = new VBox(20);
        incomeLayout.getChildren().addAll(incomeLabel,currentIncome,addIncomeLabel,textField2,addIncomeBut,homeBut4);

        Scene incomeScene = new Scene(incomeLayout,300,250);

        incomeBut.setOnAction(event -> stage.setScene(incomeScene));
        stage.setTitle("Savings Manager");
        stage.setScene(mainScene);
        stage.show();




    }

    public static void main(String[] args) {
        launch(args);
    }


    private double[] getLastValues() throws IOException {

        //read text file and get values / if file doesn't exist create
        File myFile = new File("datafile.txt");
        double[] values = new double[3];
        if (myFile.createNewFile()){
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile.getPath()));
            writer.write("0.0,0.0,0.0");

            writer.close();
            values[0] = 0.0;
            values[1] = 0.0;
            values[2] = 0.0;
        }else{
            BufferedReader reader = new BufferedReader(new FileReader(myFile));

            String line = reader.readLine().replaceAll("/[/]","");
            String [] line2 = line.split(",");
            values = Arrays.stream(line2)
                    .mapToDouble(Double::parseDouble)
                    .toArray();
        }

        return values;
    }

    private void saveData() throws IOException {
        //get values

        //read text file and get values / if file doesn't exist create
        File myFile = new File("datafile.txt");
        double[] values = new double[3];
        values[0] = Expenses.getInstance().getExpenses();
        values[1] = Savings.getInstance().getSavings();
        values[2] = Income.getInstance().getIncome();

            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile.getPath()));
            String line = Arrays.toString(values);
            String editedLine = line.replaceAll("\\[", "").replaceAll("\\]","");
            writer.write(editedLine);
            System.out.println(Arrays.toString(values));

            writer.close();

        }


}



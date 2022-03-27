package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    Expenses expenses = Expenses.getInstance();
    Savings savings = Savings.getInstance();
    Income income = Income.getInstance();
    double [] initialValues = getLastValues();

    String currentScene = "home";



    @FXML
    Button overviewBut;
    @FXML
    AnchorPane anchorpane;
    @FXML
    Label incomeLabel;
    @FXML
    Label welcomemessage;
    @FXML
    Label currentExpenses,currentIncome,currentSavings;
    @FXML
    Pane incomePane,savingsPane,expensesPane;
    @FXML
    TextField savingsText,incomeText,expensesText;



    private Stage stage;
    private Scene scene;
    private Parent root;

    public FXMLController() throws IOException {
    }




    public void switchToExpenses(ActionEvent event) throws IOException {
        incomePane.setVisible(false);
        savingsPane.setVisible(false);
        expensesPane.setVisible(true);
        currentExpenses.setText("Current Expenses: "+ expenses.getExpenses());
    }

    public void switchToSavings(ActionEvent event) throws IOException {
        incomePane.setVisible(false);
        savingsPane.setVisible(true);
        expensesPane.setVisible(false);
        currentSavings.setText("Current Savings: "+ savings.getSavings());
    }


    public void switchToIncome(ActionEvent event) throws IOException {
        savingsPane.setVisible(false);
        expensesPane.setVisible(false);
        incomePane.setVisible(true);
        currentIncome.setText("Current Income: "+ income.getIncome());
    }

    public void switchToHome(ActionEvent event) throws IOException {
        savingsPane.setVisible(false);
        expensesPane.setVisible(false);
        incomePane.setVisible(false);
    }

    public void add(ActionEvent event) throws IOException {

        if(savingsPane.isVisible()){
            savings.addSavings(Double.parseDouble(savingsText.getText()));
            currentSavings.setText("Current Savings: "+ savings.getSavings());
        } else if (expensesPane.isVisible()){
            expenses.addExpenses(Double.parseDouble(expensesText.getText()));
            currentExpenses.setText("Current Expenses: "+ expenses.getExpenses());
        } else if (incomePane.isVisible()){
            income.addIncome(Double.parseDouble(incomeText.getText()));
            currentIncome.setText("Current Income: "+ income.getIncome());
        }
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
            String line = reader.readLine().replaceAll("/[/]", "");
            String[] line2 = line.split(",");
            values = Arrays.stream(line2)
                    .mapToDouble(Double::parseDouble)
                    .toArray();

        }

        return values;
    }

    public void saveData() throws IOException {
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


        writer.close();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

            expenses.addExpenses(initialValues[0]);
            savings.addSavings(initialValues[1]);
            income.addIncome(initialValues[2]);


    }
}
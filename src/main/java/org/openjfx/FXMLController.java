package org.openjfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    public static final String CURRENT_INCOME = "Current Income: ";
    public static final String CURRENT_EXPENSES = "Current Expenses: ";
    public static final String CURRENT_SAVINGS = "Current Savings: ";
    Expenses expenses = Expenses.getInstance();
    Savings savings = Savings.getInstance();
    Income income = Income.getInstance();
    double[] initialValues = getLastValues();


    @FXML
    Label monthlyIncome;
    @FXML
    Label weeklyIncome;
    @FXML
    Label yearlyIncome;
    @FXML
    Label welcomemessage;
    @FXML
    Label currentExpenses;
    @FXML
    Label currentIncome;
    @FXML
    Label currentSavings;
    @FXML
    Pane incomePane;
    @FXML
    Pane savingsPane;
    @FXML
    Pane expensesPane;
    @FXML
    Pane homePane;
    @FXML
    TextField savingsText;
    @FXML
    TextField incomeText;
    @FXML
    TextField expensesText;
    @FXML
    TextField savingsText1;
    @FXML
    TextField incomeText1;
    @FXML
    TextField expensesText1;


    public FXMLController() throws IOException {

    }


    public void switchToExpenses() {
        incomePane.setVisible(false);
        savingsPane.setVisible(false);
        homePane.setVisible(false);
        expensesPane.setVisible(true);
        currentExpenses.setText(CURRENT_EXPENSES + expenses.getExpenses());
    }

    public void switchToSavings() {
        incomePane.setVisible(false);
        homePane.setVisible(false);
        expensesPane.setVisible(false);
        savingsPane.setVisible(true);

        currentSavings.setText(CURRENT_SAVINGS + savings.getSavings());
    }


    public void switchToIncome() {
        savingsPane.setVisible(false);
        expensesPane.setVisible(false);
        homePane.setVisible(false);
        incomePane.setVisible(true);
        currentIncome.setText(CURRENT_INCOME + income.getIncome());
    }

    public void switchToHome() {
        savingsPane.setVisible(false);
        expensesPane.setVisible(false);
        incomePane.setVisible(false);
        homePane.setVisible(true);
    }

    public void add() throws IOException {

        if (savingsPane.isVisible()) {
            savings.addSavings(Double.parseDouble(savingsText.getText()));
            savingsText.clear();
            currentSavings.setText(CURRENT_SAVINGS + savings.getSavings());
            saveData();
        } else if (expensesPane.isVisible()) {
            expenses.addExpenses(Double.parseDouble(expensesText.getText()));
            expensesText.clear();
            currentExpenses.setText(CURRENT_EXPENSES + expenses.getExpenses());
            saveData();
        } else if (incomePane.isVisible()) {
            income.addIncome(Double.parseDouble(incomeText.getText()));
            incomeText.clear();
            currentIncome.setText(CURRENT_INCOME + income.getIncome());
            saveData();
        }
    }

    public void reduce() throws IOException {

        if (savingsPane.isVisible()) {
            savings.removeSavings(Double.parseDouble(savingsText1.getText()));
            savingsText1.clear();
            currentSavings.setText(CURRENT_SAVINGS + savings.getSavings());
            saveData();
        } else if (expensesPane.isVisible()) {
            expenses.removeExpenses(Double.parseDouble(expensesText1.getText()));
            expensesText1.clear();
            currentExpenses.setText(CURRENT_EXPENSES + expenses.getExpenses());
            saveData();
        } else if (incomePane.isVisible()) {
            income.removeIncome(Double.parseDouble(incomeText1.getText()));
            incomeText1.clear();
            currentIncome.setText(CURRENT_INCOME + income.getIncome());
            saveData();
        }
    }

    private double[] getLastValues() throws IOException {

        //read text file and get values / if file doesn't exist create
        File myFile = new File("datafile.txt");
        double[] values = new double[3];
        if (myFile.createNewFile()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(myFile.getPath()))) {

                writer.write("0.0,0.0,0.0");
                values[0] = 0.0;
                values[1] = 0.0;
                values[2] = 0.0;
            }


        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
                String line = reader.readLine().replaceAll("/[/]", "");
                String[] line2 = line.split(",");
                values = Arrays.stream(line2)
                        .mapToDouble(Double::parseDouble)
                        .toArray();

            }


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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(myFile.getPath()))) {
            String line = Arrays.toString(values);
            String editedLine = line.replaceAll("\\[", "").replaceAll("\\]", "");
            writer.write(editedLine);


        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        expenses.addExpenses(initialValues[0]);
        savings.addSavings(initialValues[1]);
        income.addIncome(initialValues[2]);

        String incomeYear = String.format("%.2f", income.getIncome() * 12);
        String weekIncome = String.format("%.2f", (income.getIncome() - expenses.getExpenses()) / 4);
        String monthIncome = String.format("%.2f", income.getIncome() - expenses.getExpenses());
        yearlyIncome.setText("Current yearly income: " + incomeYear);
        monthlyIncome.setText("Current monthly disposal income: " + monthIncome);
        weeklyIncome.setText("(per week: " + weekIncome + " )");


    }
}
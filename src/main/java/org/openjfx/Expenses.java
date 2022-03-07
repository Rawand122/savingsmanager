package org.openjfx;

public class Expenses {

    double expenses = 0;

    public double getExpenses() {
        return expenses;
    }

    public void addExpenses(double expenses) {
        this.expenses += expenses;
    }

    public void removeExpenses(double expenses) {
        this.expenses -= expenses;
    }
}

package org.openjfx;

public class Expenses {
    private static Expenses instance;
    private Expenses(){};

    public static Expenses getInstance(){
        if(instance == null) {
            instance = new Expenses();
        }

        return instance;
    };
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

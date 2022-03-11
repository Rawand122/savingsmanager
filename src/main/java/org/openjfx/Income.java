package org.openjfx;

public class Income {
    private static Income instance;

    private Income() {
    }

    ;

    public static Income getInstance() {
        if (instance == null) {
            instance = new Income();
        }

        return instance;
    }

    ;
    double income = 0;

    public double getIncome() {
        return income;
    }

    public void addIncome(double income) {
        this.income += income;
    }

    public void removeIncome(double income) {
        this.income -= income;
    }
}

package org.openjfx;

public class Savings {
    private static Savings instance;

    private Savings() {
    }

    ;

    public static Savings getInstance() {
        if (instance == null) {
            instance = new Savings();
        }

        return instance;
    }

    ;

    double savings = 0;

    public double getSavings() {
        return savings;
    }

    public void addSavings(double savings) {
        this.savings += savings;
    }

    public void removeSavings(double savings) {
        this.savings -= savings;
    }
}

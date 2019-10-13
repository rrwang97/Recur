package com.example.recur;

import java.util.Date;

public class Payment {
    String name;
    double amount;
    int interval;
    Date endDate;
    String category;

    public Payment(String name, double amount, int interval, Date endDate, String category) {
        this.name = name;
        this.amount = amount;
        this.interval = interval;
        this.endDate = endDate;
        this.category = category;
    }

    public Payment paymentInfo() {
        return this;
    }

    public String toString() {
        return "I'm paying " + this.name + " $" + this.amount + " every " + this.interval +
                " until " + this.endDate.toString() + " for " + this.category;
    }
}

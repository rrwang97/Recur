package com.example.recur;

import java.util.Date;

public class Payment {
    String name;
    double amount;
    int interval;
    Date startDate;
    Date endDate;
    String category;

    public Payment(String name, double amount, int interval, Date startDate, Date endDate, String category) {
        this.name = name;
        this.amount = amount;
        this.interval = interval;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
    }

    public String getName() {
        return this.name;
    }

    public String getAmount() {
        return this.amount + "/";
    }

    public String getRecur() {
        if (this.interval % 7 != 0) {
            return this.interval + "days";
        } else if (this.interval % 365 == 0) {
            return this.interval + "years";
        } else {
            return this.interval + "weeks";
        }
    }

    public String toString() {
        return "I'm paying " + this.name + " $" + this.amount + " every " + this.interval +
                " until " + this.endDate.toString() + " for " + this.category;
    }
}

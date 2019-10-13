package com.example.recur;

import java.util.Date;

public class Payment {
    String name;
    double amount;
    int recur;
    Date startDate;
    Date endDate;

    public Payment(String nameIn, double amountIn, int repeat, Date start, Date end) {
        name = nameIn;
        amount = amountIn;
        recur = repeat;
        startDate = start;
        endDate = end;
    }

    public String getName() {
        return this.name;
    }

    public String getAmount() {
        return this.amount + "/";
    }

    public String getRecur() {
        if (this.recur % 7 != 0) {
            return this.recur + "days";
        } else if (this.recur % 365 == 0) {
            return this.recur + "years";
        } else {
            return this.recur + "weeks";
        }
    }

    public Payment paymentInfo() {
        return this;
    }
}

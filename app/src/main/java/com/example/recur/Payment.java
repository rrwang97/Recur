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

    public Payment paymentInfo() {
        return this;
    }
}

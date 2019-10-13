package com.example.recur;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {
    String username;
    String password;
    String nickname;
    Map<String, Payment> paymentMap;

    public void createUser(String name, String pass, String nicknameIn) {
        username = name;
        password = pass;
        nickname = nicknameIn;
        Map<String, Payment> paymentMap = new HashMap<>();
    }

    public void addPayment(String name, double amount, int repeat, Date start, String end) {
        Payment newPayment = new Payment(name, amount, repeat, start, end);
        paymentMap.put(name, newPayment);
    }
}

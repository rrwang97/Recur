package com.example.recur;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {
    String username;
    String password;
    String nickname;
    Map<String, Payment> paymentMap;

    public User(String name, String pass, String nicknameIn) {
        username = name;
        password = pass;
        nickname = nicknameIn;
        Map<String, Payment> paymentMap = new HashMap<>();
    }

    public void addPayment(String name, double amount, int repeat, Date start, Date end) {
        Payment newPayment = new Payment(name, amount, repeat, start, end);
        paymentMap.put(name, newPayment);
    }

    public void removePayment(String name) {
        paymentMap.remove(name);
    }
}

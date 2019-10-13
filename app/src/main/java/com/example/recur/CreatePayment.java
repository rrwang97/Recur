package com.example.recur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CreatePayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_payment);
    }

    public void setPaymentValues() {
        try {
            EditText nameText = findViewById(R.id.nameInput);
            String name = nameText.getText().toString();

            EditText amountText = findViewById(R.id.amountInput);
            double amount = Double.parseDouble(amountText.getText().toString());

            EditText intervalText = findViewById(R.id.intervalInput);
            int interval = Integer.parseInt(intervalText.getText().toString());

            EditText endDateText = findViewById(R.id.endDateInput);
            Date endDate = new SimpleDateFormat("MM/DD/YYYY").parse(endDateText.getText().toString());

            EditText categoryText = findViewById(R.id.categoryInput);
            String category = intervalText.getText().toString();

            Payment newPayment = new Payment(name, amount, interval, endDate, category);
            System.out.println(newPayment.toString());
        } catch (Exception e) {
            System.out.println("Failed to create payment");
        }
    }
}

package com.example.recur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CreatePayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_payment);
    }

    public void setPaymentValues(View view) {
        try {
            EditText nameText = findViewById(R.id.nameInput);
            String name = nameText.getText().toString();

            EditText amountText = findViewById(R.id.amountInput);
            double amount = Double.parseDouble(amountText.getText().toString());

            EditText intervalText = findViewById(R.id.intervalInput);
            int interval = Integer.parseInt(intervalText.getText().toString());

            EditText endDateText = findViewById(R.id.endDateInput);
            Date endDate = new SimpleDateFormat("MM/dd/yyyy").parse(endDateText.getText().toString());

            EditText categoryText = findViewById(R.id.categoryInput);
            String category = categoryText.getText().toString();

            Payment newPayment = new Payment(name, amount, interval, endDate, category);

        } catch (Exception e) {
            System.out.println("Failed to create payment");
            System.out.println(e.toString());
            Snackbar errorSnackbar = Snackbar.make(view, "Failed to create payment, try again",
                    5000);
            errorSnackbar.show();
        }
    }
}

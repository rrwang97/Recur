package com.example.recur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CreatePayment extends AppCompatActivity {
    DatabaseReference payments;
    List<Payment> payList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_payment);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        this.payments = database.getReference("payments");
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

            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            Date startDate = new Date();

            Payment newPayment = new Payment(name, amount, interval, startDate, endDate, category);

            this.writeNewPayment(newPayment);

            // TODO: 10/13/2019
            // Write payment to file here

        } catch (Exception e) {
            System.out.println("Failed to create payment");
            System.out.println(e.toString());
            Snackbar errorSnackbar = Snackbar.make(view, "Failed to create payment, try again",
                    5000);
            errorSnackbar.show();
        }
    }

    public void writeNewPayment(Payment newPayment) {
        this.payments.child(newPayment.name).setValue(newPayment);
    }



    public void writeJsonStream(OutputStream out, List<Payment> paymentList) throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        writeMessagesArray(writer, paymentList);
        writer.close();
    }

    public void writeMessagesArray(JsonWriter writer, List<Payment> paymentList) throws IOException {
        writer.beginArray();
        for (Payment p : paymentList) {
            writeObject(writer, p);
        }
        writer.endArray();
    }

    public void writeObject(JsonWriter writer, Payment p) throws IOException {
        writer.beginObject();
        writer.name("id").value(p.name);
        writer.name("amount").value(p.amount);
        writer.name("interval").value(p.interval);
        writer.name("start").value(p.startDate.toString());
        writer.name("end").value(p.endDate.toString());
        writer.name("category").value(p.category);
    }

    public List<Payment> readJsonStream(InputStream in) throws Exception {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readPaymentsArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<Payment> readPaymentsArray(JsonReader reader) throws Exception {
        List<Payment> payments = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            payments.add(readPayment(reader));
        }
        reader.endArray();
        return payments;
    }

    public Payment readPayment(JsonReader reader) throws Exception {
        String name = "";
        double amount = 0.0;
        int interval = 0;
        Date startDate = new Date();
        Date endDate = new Date();
        String category = "";

        reader.beginObject();
        while (reader.hasNext()) {
            String rName = reader.nextName();
            if (rName == "id") {
                name = reader.nextString();
            } else if (rName == "amount") {
                amount = reader.nextDouble();
            } else if (rName == "interval") {
                interval = reader.nextInt();
            } else if (rName == "startDate") {
                startDate = new SimpleDateFormat("dd/MM/yyyy").parse(reader.nextString());
            } else if (rName == "endDate") {
                endDate = new SimpleDateFormat("MM/dd/yyyy").parse(reader.nextString());
            } else {
                category = reader.nextString();
            }
        }
        reader.endObject();
        return new Payment(name, amount, interval, startDate, endDate, category);
    }
}

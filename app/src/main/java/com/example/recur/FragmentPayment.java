package com.example.recur;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;
import java.util.List;

public class FragmentPayment extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<Payment> paymentsList;
    DatabaseReference payments;

    public FragmentPayment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        this.payments = database.getReference("payments");
        ValueEventListener paymentsListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable children = dataSnapshot.getChildren();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Payment curPayment = snapshot.getValue(Payment.class);
                    paymentsList.add(curPayment);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Tag", "paymentsListener:onCancelled", databaseError.toException());
            }
        };
        this.payments.addValueEventListener(paymentsListener);

        v = inflater.inflate(R.layout.fragment_item_payment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), this.paymentsList);  //Need to get the payment storage
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);
        return v;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        this.payments = database.getReference("payments");
//        ValueEventListener paymentsListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Iterable children = dataSnapshot.getChildren();
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Payment curPayment = snapshot.getValue(Payment.class);
//                    paymentsList.add(curPayment);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Log.w("Tag", "paymentsListener:onCancelled", databaseError.toException());
//            }
//        };
//        this.payments.addValueEventListener(paymentsListener);
//    }

}

package com.example.recur.ui.payflows;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recur.R;

public class PayflowsFragment extends Fragment {

    private PayflowsViewModel payflowsViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        payflowsViewModel =
                ViewModelProviders.of(this).get(PayflowsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_payflows, container, false);
        return root;
    }

}
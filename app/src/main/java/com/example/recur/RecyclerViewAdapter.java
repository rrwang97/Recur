package com.example.recur;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Payment> mData;

    public RecyclerViewAdapter(Context mContext, Map<String, Payment> mData) {
        Set<String> keys = mData.keySet();
        List<Payment> data = new ArrayList<>();
        for (String k: keys){
            data.add(mData.remove(k));
        }
        this.mContext = mContext;
        this.mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.fragment_item_payment, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_amount.setText(mData.get(position).getAmount());
        holder.tv_freq.setText(mData.get(position).getRecur());
//        holder.img.setImageResource(mData.get(position).);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name;
        private TextView tv_amount;
        private TextView tv_freq;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.name_payment);
            tv_amount = (TextView) itemView.findViewById(R.id.amount_payment);
            tv_freq = (TextView) itemView.findViewById(R.id.reoccur_payment);
            img = (ImageView) itemView.findViewById(R.id.img_payment);        }
    }
}

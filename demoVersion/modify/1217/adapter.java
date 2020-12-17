package com.example.schedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class adapter extends RecyclerView.Adapter<adapter.ItemViewHolder> implements OnLocationItemClickListener {

    public ArrayList<String> listData = new ArrayList<>();
    OnLocationItemClickListener listener;
    Context context;
    public String returnData = new String();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //context = parent.getContext();
        View view = inflater.inflate(R.layout.activity_recyclerview_item, parent ,false);
        return new ItemViewHolder(view, this);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        returnData = listData.get(position);
        holder.onBind(returnData);

    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }

    public String getItem(int position) {

        return listData.get(position);
    }

    void addItem(String data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
    }
    void onBind(String data) {
        this.listData = listData;
        //    b1.setOnClickListener(this);
    }
    public void setOnItemClicklistener(OnLocationItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ItemViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private Button b1;
        Context context;
        ItemViewHolder(View itemView, final OnLocationItemClickListener listener) {
            super(itemView);

            b1 = itemView.findViewById(R.id.bt_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null) {
                        Intent intent = new Intent(context, busSchedule.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        listener.onItemClick(ItemViewHolder.this, v, position);
                        context.startActivity(intent);
                    }

                }
            });
        }


        void onBind(String data) {
            b1.setText(data);
        //    b1.setOnClickListener(this);
        }

        private void gotoMainActivity(){
            Intent intent = new Intent(context, busSchedule.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }

        /*@Override
        public void onClick(View v) {
//            returnData = listData.get(v.getId());
 //           returnData = listData.get(v.getId());

            /*Toast.makeText(context, returnData, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context.getApplicationContext(), MainActivity.class);
            intent.putExtra("departure", returnData);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
          }*/

    }


}


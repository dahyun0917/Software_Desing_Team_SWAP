package com.example.schedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ItemViewHolder> {


    private ArrayList<location> listData = new ArrayList<>();
    public String loc = new String();
    public Context context;


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recyclerview_item, parent, false);
        return new ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }

    void addItem(location data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Button b1;
        private TextView t1;
        private TextView t2;
        private location data;


        ItemViewHolder(View itemView) {
            super(itemView);
            b1 = itemView.findViewById(R.id.bt_arrive);
            t1 = itemView.findViewById(R.id.text_departure);
            t2 = itemView.findViewById(R.id.text_arrival);
        }

        void onBind(location data) {
            this.data = data;
            b1.setText(data.getTitle());
            b1.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context.getApplicationContext(), busSchedule.class);
            Bundle bundle = intent.getExtras();
            String reLoc = new String();
            reLoc = data.getTitle();
            intent.putExtra("depart", reLoc);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }
    }

}


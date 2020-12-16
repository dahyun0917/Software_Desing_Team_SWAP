package com.example.schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ItemViewHolder> implements OnLocationItemClickListener {

    OnLocationItemClickListener listener;
    Context context;
    public ArrayList<String> listData = new ArrayList<>();
    public String returnData = new String();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.

        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recyclerview_item, parent, false);
        return new ItemViewHolder(view, listener);

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

    @Override
    public void onItemClick(ItemViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }


    }

    public void setOnItemClicklistener(OnLocationItemClickListener listener) {
        this.listener = listener;
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder {

        private Button b1;

        ItemViewHolder(View itemView, final OnLocationItemClickListener listener) {
            super(itemView);

            b1 = itemView.findViewById(R.id.bt_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null) {
                        listener.onItemClick(ItemViewHolder.this, v, position);
                    }
                }
            });
        }


        void onBind(String data) {
            b1.setText(data);
            //b1.setOnClickListener(this);
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


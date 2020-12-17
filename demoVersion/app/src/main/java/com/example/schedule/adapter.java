package com.example.schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {


    private ArrayList<String> mData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button button1;

        ViewHolder(View itemView) {
            super(itemView);

            button1 = itemView.findViewById(R.id.bt_item);
        }

    }

    adapter(ArrayList<String> list) {
        mData = list;
    }

    @Override
    public adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_recyclerview_item, parent, false);
        adapter.ViewHolder vh = new adapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(adapter.ViewHolder holder, int position) {
        String text = mData.get(position);
        holder.button1.setText(text);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}

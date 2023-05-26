package com.example.cardiacrecorder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<DataClass>list;

    public MyAdapter(Context context, ArrayList<DataClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataClass dataClass = list.get(position);
        holder.sys.setText(dataClass.getSys());
        holder.dis.setText(dataClass.getDis());
        holder.bpm.setText(dataClass.getBpm());
        holder.cmnt.setText(dataClass.getCmnt());

        holder.editimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, edit.class);
                context.startActivity(intent);
            }
        });

        holder.delimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Delete from list
            }
        });
        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, details.class);
//                intent.putExtra("key", ussr);
//                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
//                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
//                intent.putExtra("Desc", dataList.get(holder.getAdapterPosition()).getDataDesc());

                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView sys,dis,bpm,cmnt;
        ImageView editimg,delimg;
        CardView recCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sys = itemView.findViewById(R.id.un1);
            dis = itemView.findViewById(R.id.un2);
            bpm = itemView.findViewById(R.id.un3);
            cmnt = itemView.findViewById(R.id.textView10);
            editimg = itemView.findViewById(R.id.image2);
            delimg = itemView.findViewById(R.id.image);
            recCard = itemView.findViewById(R.id.recCard);
        }
    }
}
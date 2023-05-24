package com.example.cardiacrecorder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;

    public void setSearchList(List<DataClass> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }

    public MyAdapter(Context context, List<DataClass> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.dist.setText(dataList.get(position).getDataDis());
        holder.syst.setText(dataList.get(position).getDatasys());
        holder.cmnt.setText(dataList.get(position).getDatacom());
        holder.bpm.setText(dataList.get(position).getDatabpm());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, dummy.class);
//                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
//                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
//                intent.putExtra("Desc", dataList.get(holder.getAdapterPosition()).getDataDesc());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView syst, dist, bpm, cmnt;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        cmnt = itemView.findViewById(R.id.textView10);
        syst = itemView.findViewById(R.id.un1);
        dist = itemView.findViewById(R.id.un2);
        bpm = itemView.findViewById(R.id.un3);
        recCard = itemView.findViewById(R.id.recCard);
    }
}

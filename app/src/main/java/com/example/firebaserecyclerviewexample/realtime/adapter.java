package com.example.firebaserecyclerviewexample.realtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebaserecyclerviewexample.R;

import java.util.ArrayList;

public abstract class adapter extends RecyclerView.Adapter<adapter.ViewHolder> implements Adapter {

private ArrayList<module> list;
private android.content.Context Context;


    adapter(Context context, ArrayList<module> list) {

        this.Context=context;
        this.list=list;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(Context).inflate(R.layout.module_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textlist.setText(list.get(position).getDataoflist());


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textlist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


             textlist =itemView.findViewById(R.id.text_list);




        }
    }


}

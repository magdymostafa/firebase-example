package com.example.firebaserecyclerviewexample.firestore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebaserecyclerviewexample.R;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.adapterHolder> {


    private ArrayList<com.example.firebaserecyclerviewexample.firestore.module> list;
    private android.content.Context Context;


    adapter(android.content.Context context, ArrayList<com.example.firebaserecyclerviewexample.firestore.module> list) {

        this.Context=context;
        this.list=list;


    }


    @NonNull
    @Override
    public adapterHolder onCreateViewHolder( ViewGroup parent, int viewType) {


        return new adapter.adapterHolder(LayoutInflater.from(Context).inflate(R.layout.module_view,parent,false));
    }

    @Override
    public void onBindViewHolder( adapter.adapterHolder holder, int position) {

        module user=list.get(position);
        holder.textv.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class adapterHolder extends RecyclerView.ViewHolder{

        TextView textv;

        public adapterHolder(View itemView) {
            super(itemView);

            textv=itemView.findViewById(R.id.text_list);

        }
    }



}


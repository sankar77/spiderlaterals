package com.example.sankar.recyclerviewexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sankar.recyclerviewexample.database.DBhelper;

import java.util.ArrayList;

/**
 * Created by Nagarajan on 14-06-2016.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    ArrayList<MyDetailsVo> list;
    DBhelper db;
    Context context;
    public CustomAdapter(ArrayList<MyDetailsVo> list,DBhelper db,Context context) {
        this.list = list;
        this.db=db;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customadapters, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        holder.name.setText(list.get(position).getName());
        holder.mono.setText(list.get(position).getMobileno());
        holder.AG.setText(list.get(position).getAge());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteRecord(list.get(position).getName());
                list.remove(position);
                notifyDataSetChanged();
            }
        });
       /* holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("Name", holder.name.getText().toString());
                context.startActivity(intent);
            }
        });*/
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("Name", list.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, mono,AG;
        ImageView delete;
        View v;
        public ViewHolder(View itemView) {
            super(itemView);
            v=itemView;
            name = (TextView) itemView.findViewById(R.id.name);
            mono = (TextView) itemView.findViewById(R.id.mobino);
            AG= (TextView) itemView.findViewById(R.id.age);
            delete=(ImageView) itemView.findViewById(R.id.deletebtn);
        }
    }
}
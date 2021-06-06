package com.example.activitymysql.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.activitymysql.R;
import com.example.activitymysql.database.Teman;

import java.util.ArrayList;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.TemanViewHolder> {
    private ArrayList<Teman> listData;

    public TemanAdapter(ArrayList<Teman> listData){
        this.listData = listData;
    }

    @Override
    public TemanViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_teman,parent,false);
        return new TemanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TemanViewHolder holder, int position){
        String nm, tlp;

        nm = listData.get(position).getNama();
        tlp = listData.get(position).getTelpon();

        holder.namaTxt.setTextColor(Color.BLUE);
        holder.namaTxt.setTextSize(20);
        holder.namaTxt.setText(nm);
        holder.telponTxt.setText(tlp);
        holder.cardku.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                return true;
            }
        });
    }
    @Override
    public int getItemCount(){
        return (listData != null)?listData.size() : 0;
    }
    public class TemanViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView namaTxt, telponTxt;
        public TemanViewHolder(View view){
            super(view);
            cardku = (CardView) view.findViewById(R.id.cardku);
            namaTxt = (TextView) view.findViewById(R.id.txtNama);
            telponTxt = (TextView) view.findViewById(R.id.txtTelpon);
        }
    }
}
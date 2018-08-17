package com.example.iobejan.weather.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iobejan.weather.R;
import com.example.iobejan.weather.interfaces.OnItemClickListener;

import java.util.ArrayList;

public class MyPlacesAdapter extends RecyclerView.Adapter<MyPlacesAdapter.ViewHolder> {
    private ArrayList<String> data;

    private OnItemClickListener onItemClickListener;

    public MyPlacesAdapter(ArrayList<String> data){
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyPlacesAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_places_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_ = itemView.findViewById(R.id.tv_);
            itemView.setOnClickListener(this);
        }

        void bind(){
            int position = getAdapterPosition();
            tv_.setText(data.get(position));
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null){
                onItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }
}

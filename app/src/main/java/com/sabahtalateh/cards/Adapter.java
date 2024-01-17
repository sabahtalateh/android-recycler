package com.sabahtalateh.cards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    List<Model> mm;

    ItemClickListener clickListener;

    public Adapter(List<Model> mm) {
        this.mm = mm;
    }

    public void setClickListener(ItemClickListener icl) {
        this.clickListener = icl;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Model m = mm.get(position);
        holder.image.setImageResource(m.image);
        holder.title.setText(m.title);
    }

    @Override
    public int getItemCount() {
        return mm.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;

        TextView title;

        public Holder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onClick(v, getAdapterPosition());
            }
        }
    }
}

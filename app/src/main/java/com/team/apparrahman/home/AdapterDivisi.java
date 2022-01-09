package com.team.apparrahman.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team.apparrahman.R;

import java.util.List;

public class AdapterDivisi extends RecyclerView.Adapter<AdapterDivisi.DivisiHolder> {

    private static final String TAG = "DivisiAdapter";
    List<ItemDivisi> itemDivisi;

    public AdapterDivisi(List<ItemDivisi> itemDivisi) {
        this.itemDivisi = itemDivisi;
    }

    @NonNull
    @Override
    public AdapterDivisi.DivisiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvdivisi_item,parent,false);

        return new DivisiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDivisi.DivisiHolder holder, int position) {
        ItemDivisi divisItem = itemDivisi.get(position);
        holder.title.setText(divisItem.getTlDivisi());
        holder.desc.setText(divisItem.getDsDivisi());
        boolean isExpands = divisItem.isExpDivisi();
        holder.expandLayout.setVisibility(isExpands ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return itemDivisi.size();
    }

    public class DivisiHolder extends RecyclerView.ViewHolder {

        TextView title, desc;
        LinearLayout expandLayout;
        private static final String TAG = "AdapterDivisi";

        public DivisiHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_cv);
            desc = itemView.findViewById(R.id.desc_cv);
            expandLayout = itemView.findViewById(R.id.expandable_cardview);

            title.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                ItemDivisi divisi = itemDivisi.get(pos);
                divisi.setExpDivisi(!divisi.isExpDivisi());
                notifyItemChanged(pos);
            });
        }
    }
}

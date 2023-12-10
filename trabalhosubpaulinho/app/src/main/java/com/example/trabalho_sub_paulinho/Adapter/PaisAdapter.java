package com.example.trabalho_sub_paulinho.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalho_sub_paulinho.R;
import com.example.trabalho_sub_paulinho.dto.PaisDTO;

import java.util.List;

public class PaisAdapter extends RecyclerView.Adapter<PaisAdapter.ViewHolder> {

    private List<PaisDTO> paises;

    public PaisAdapter(List<PaisDTO> paises) {
        this.paises = paises;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pais, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PaisDTO pais = paises.get(position);
        holder.titleTextView.setText(pais.getCodigo());
        holder.bodyTextView.setText(pais.getDescricao());
    }

    @Override
    public int getItemCount() {
        return paises.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView bodyTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            bodyTextView = itemView.findViewById(R.id.bodyTextView);
        }
    }
}

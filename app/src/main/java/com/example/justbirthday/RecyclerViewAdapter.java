package com.example.justbirthday;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.getNameRVRow().setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameRVRow, dateRVRow;
        private ImageView iconRVRow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameRVRow = (TextView) itemView.findViewById(R.id.NameRVRow);
            iconRVRow = (ImageView) itemView.findViewById(R.id.IconRVRow);
            dateRVRow = (TextView) itemView.findViewById(R.id.DateRVRow);
        }

        public TextView getNameRVRow() {
            return nameRVRow;
        }
        public TextView getDateRVRow() {
            return dateRVRow;
        }
        public ImageView getIconRVRow() {
            return iconRVRow;
        }
    }
}

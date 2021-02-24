package com.brontocyber.jetpack3_fahmihusin.adapter.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brontocyber.jetpack3_fahmihusin.R;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;
import com.bumptech.glide.Glide;

public class DetailMoviesAdapter extends RecyclerView.Adapter<DetailMoviesAdapter.DetailViewHolder> {

    private Acara detailAcara;
    public DetailMoviesAdapter(Acara data){
        this.detailAcara = data;
    }


    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R. layout.item_detail_acara, parent, false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(detailAcara.getPoster_path())
                .into(holder.gambarDetail);
        holder.judulDetail.setText(detailAcara.getTitle());
        holder.rilisDetail.setText(detailAcara.getRelease_date());
        holder.descDetail.setText(detailAcara.getOverview());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder {
        ImageView gambarDetail;
        TextView judulDetail, rilisDetail, descDetail;
        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            gambarDetail = itemView.findViewById(R.id.detail_gambar);
            judulDetail = itemView.findViewById(R.id.detail_judul);
            rilisDetail = itemView.findViewById(R.id.detail_rilis);
            descDetail = itemView.findViewById(R.id.detail_deskripsi);
        }
    }
}

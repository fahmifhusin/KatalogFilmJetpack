package com.brontocyber.jetpack3_fahmihusin.adapter.main;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brontocyber.jetpack3_fahmihusin.R;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavTv;
import com.brontocyber.jetpack3_fahmihusin.ui.detail.DetailTvActivity;
import com.bumptech.glide.Glide;

import java.util.List;

import static com.brontocyber.jetpack3_fahmihusin.ui.main.MainActivity.db;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.AcaraViewHolder> {

    private List<Acara> dataTvShow;

    public TvAdapter(List<Acara> list) {
        this.dataTvShow = list;
    }

    @NonNull
    @Override
    public AcaraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_acara, parent, false);
        final AcaraViewHolder holder = new AcaraViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(v.getContext(), DetailTvActivity.class);
                detail.putExtra(DetailTvActivity.idTv, dataTvShow.get(holder.getAdapterPosition()).getId());
                v.getContext().startActivity(detail);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AcaraViewHolder holder, int position) {
        final Acara acara = dataTvShow.get(position);
        Glide.with(holder.itemView.getContext())
                .load(acara.getPoster_path())
                .into(holder.gambar);
        holder.judul.setText(acara.getTitle());
        holder.rilis.setText(acara.getRelease_date());
        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(acara.getId());
                String favPoster = acara.getPoster_path();
                String favTitle = acara.getTitle();
                String favRelease = acara.getRelease_date();

                FavTv fav = new FavTv(id, favPoster, favTitle, favRelease);
                holder.favBtn.setSelected(!holder.favBtn.isSelected());
                try {
                    db.favTvDao().addFavData(fav);
                    Toast.makeText(v.getContext(), "Add to Favorite", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.getMessage();
                    db.favTvDao().delete(fav);
                    Toast.makeText(v.getContext(), "Remove from Favorite", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataTvShow.size();
    }

    public class AcaraViewHolder extends RecyclerView.ViewHolder {
        ImageView gambar;
        ImageButton favBtn;
        TextView judul, rilis;

        public AcaraViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.gambar);
            judul = itemView.findViewById(R.id.judul);
            rilis = itemView.findViewById(R.id.rilis);
            favBtn = itemView.findViewById(R.id.fav_button);
        }
    }
}

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
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavMovies;
import com.brontocyber.jetpack3_fahmihusin.ui.detail.DetailMovieActivity;
import com.bumptech.glide.Glide;

import java.util.List;

import static com.brontocyber.jetpack3_fahmihusin.ui.main.MainActivity.db;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.AcaraViewHolder> {

    private List<Acara> dataMovies;
    public MoviesAdapter(List<Acara> list) {
        this.dataMovies = list;
    }

    @NonNull
    @Override
    public AcaraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_acara, parent, false);
        final AcaraViewHolder holder = new AcaraViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(v.getContext(), DetailMovieActivity.class);
                detail.putExtra(DetailMovieActivity.idAcara, dataMovies.get(holder.getAdapterPosition()).getId());
                v.getContext().startActivity(detail);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AcaraViewHolder holder, int position) {
        final Acara acara = dataMovies.get(position);
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
                FavMovies fav = new FavMovies(id, favPoster, favTitle, favRelease);
                try {
                    db.favMoviesDao().addFavData(fav);
                    Toast.makeText(v.getContext(), "Add to Favorite", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.getMessage();
                    db.favMoviesDao().delete(fav);
                    Toast.makeText(v.getContext(), "Remove from Favorite", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataMovies.size();
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

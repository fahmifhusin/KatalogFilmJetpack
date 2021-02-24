package com.brontocyber.jetpack3_fahmihusin.adapter.favorite;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.brontocyber.jetpack3_fahmihusin.R;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavMovies;
import com.bumptech.glide.Glide;

import java.util.List;

import static com.brontocyber.jetpack3_fahmihusin.ui.main.MainActivity.db;

public class PagedMoviesAdapter extends PagedListAdapter<FavMovies, PagedMoviesAdapter.MoviesFavHolder> {
    private Activity activity;

    public PagedMoviesAdapter(Activity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }

    @NonNull
    @Override
    public MoviesFavHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_acara, parent, false);
        return new MoviesFavHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesFavHolder holder, int position) {
        final FavMovies fav = getItem(position);
        int id = fav.getId();
        Log.d("id", String.valueOf(id));
        Glide.with(holder.itemView.getContext())
                .load(fav.getPoster_path())
                .into(holder.imageView);
        holder.titleAcara.setText(fav.getTitle());
        holder.rilisAcara.setText(fav.getRelease_date());
        //remove favorite

        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.favMoviesDao().delete(fav);
                Toast.makeText(v.getContext(), "Delete from Favorite", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public class MoviesFavHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageButton favBtn;
        TextView titleAcara, rilisAcara;
        public MoviesFavHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gambar);
            titleAcara = itemView.findViewById(R.id.judul);
            rilisAcara = itemView.findViewById(R.id.rilis);
            favBtn = itemView.findViewById(R.id.fav_button);
        }
    }

    private static DiffUtil.ItemCallback<FavMovies> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FavMovies>() {
                @Override
                public boolean areItemsTheSame(FavMovies oldNote, FavMovies newNote) {
                    return oldNote.getTitle().equals(newNote.getTitle());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(FavMovies oldNote, @NonNull FavMovies newNote) {
                    return oldNote.equals(newNote);
                }
            };
}

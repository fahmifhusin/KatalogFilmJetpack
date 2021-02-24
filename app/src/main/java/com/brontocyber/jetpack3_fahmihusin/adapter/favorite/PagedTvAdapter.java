package com.brontocyber.jetpack3_fahmihusin.adapter.favorite;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavTv;
import com.bumptech.glide.Glide;

import static com.brontocyber.jetpack3_fahmihusin.ui.main.MainActivity.db;


public class PagedTvAdapter extends PagedListAdapter<FavTv, PagedTvAdapter.TvFavHolder> {

    private Activity activity;

    public PagedTvAdapter(Activity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }

    @NonNull
    @Override
    public TvFavHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_acara, parent, false);
        return new TvFavHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull TvFavHolder holder, int position) {
        final FavTv fav = getItem(position);
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
                db.favTvDao().delete(fav);
                Toast.makeText(v.getContext(), "Delete from Favorite", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class TvFavHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageButton favBtn;
        TextView titleAcara, rilisAcara;

        public TvFavHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gambar);
            titleAcara = itemView.findViewById(R.id.judul);
            rilisAcara = itemView.findViewById(R.id.rilis);
            favBtn = itemView.findViewById(R.id.fav_button);
        }
    }

    private static DiffUtil.ItemCallback<FavTv> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FavTv>() {
                @Override
                public boolean areItemsTheSame(FavTv oldNote, FavTv newNote) {
                    return oldNote.getTitle().equals(newNote.getTitle());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(FavTv oldNote, @NonNull FavTv newNote) {
                    return oldNote.equals(newNote);
                }
            };
}

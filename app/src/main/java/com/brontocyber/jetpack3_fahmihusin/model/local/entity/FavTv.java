package com.brontocyber.jetpack3_fahmihusin.model.local.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "fav_tv")
public class FavTv {
    @ColumnInfo(name = "id")@PrimaryKey
    @NonNull
    private int id;

    @ColumnInfo(name = "poster_path")@Nullable

    private String poster_path;
    @ColumnInfo(name = "title")@Nullable
    private String title;

    @ColumnInfo(name = "release_date")@Nullable
    private String release_date;

    public FavTv(@NonNull int id, @Nullable String poster_path,@Nullable String title,@Nullable String release_date) {
        this.id = id;
        this.poster_path = poster_path;
        this.title = title;
        this.release_date = release_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Nullable
    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(@Nullable String poster_path) {
        this.poster_path = poster_path;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(@Nullable String release_date) {
        this.release_date = release_date;
    }
}

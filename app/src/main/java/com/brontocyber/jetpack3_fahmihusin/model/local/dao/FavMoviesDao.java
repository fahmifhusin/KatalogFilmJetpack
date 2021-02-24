package com.brontocyber.jetpack3_fahmihusin.model.local.dao;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavMovies;

import java.util.ArrayList;
import java.util.List;



@Dao
public interface FavMoviesDao {

    //untuk adapter | cuma jadi perantara memori
    @Query("SELECT * FROM fav_movies")
    DataSource.Factory<Integer, FavMovies> getFavPage();

    //insert data
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addFavData(FavMovies favorite);

    //delete favitem
    @Delete
    void delete(FavMovies data);
}

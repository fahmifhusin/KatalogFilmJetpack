package com.brontocyber.jetpack3_fahmihusin.model.local.dao;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavTv;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface FavTvDao {
    //untuk adapter | cuma jadi perantara memori
    @Query("SELECT * FROM fav_tv")
    DataSource.Factory<Integer, FavTv> getFavPage();

    //insert data
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addFavData(FavTv favorite);

    //delete favitem
    @Delete
    void delete(FavTv data);

}

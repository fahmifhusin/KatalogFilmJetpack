package com.brontocyber.jetpack3_fahmihusin.model.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.brontocyber.jetpack3_fahmihusin.model.local.dao.FavMoviesDao;
import com.brontocyber.jetpack3_fahmihusin.model.local.dao.FavTvDao;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavMovies;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavTv;

import static java.time.chrono.ThaiBuddhistChronology.INSTANCE;

@Database(entities={FavMovies.class, FavTv.class},version = 1)
public abstract class AcaraDB extends RoomDatabase {

    public abstract FavMoviesDao favMoviesDao();
    public abstract FavTvDao favTvDao();

}

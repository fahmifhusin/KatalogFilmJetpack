package com.brontocyber.jetpack3_fahmihusin.model.repository;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.brontocyber.jetpack3_fahmihusin.model.local.dao.FavMoviesDao;
import com.brontocyber.jetpack3_fahmihusin.model.local.dao.FavTvDao;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavMovies;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavTv;

import static com.brontocyber.jetpack3_fahmihusin.ui.main.MainActivity.db;
import static java.time.chrono.ThaiBuddhistChronology.INSTANCE;

public class LocalRepository {

    private volatile static LocalRepository INSTANCE = null;

    public static LocalRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalRepository();
                }
            }
        }
        return INSTANCE;
    }

    public DataSource.Factory<Integer, FavMovies> getLocalMovies(){
        return db.favMoviesDao().getFavPage();
    }

    public DataSource.Factory<Integer, FavTv>  getLocalTv(){
        return db.favTvDao().getFavPage();
    }
}

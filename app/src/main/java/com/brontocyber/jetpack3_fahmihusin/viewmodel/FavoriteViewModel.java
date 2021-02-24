package com.brontocyber.jetpack3_fahmihusin.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavMovies;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavTv;
import com.brontocyber.jetpack3_fahmihusin.model.repository.AcaraRepository;
import com.bumptech.glide.load.engine.Resource;

import java.util.List;

public class FavoriteViewModel extends ViewModel {

    AcaraRepository repository;

    public FavoriteViewModel(AcaraRepository repository) {
        this.repository = repository;
    }

    public LiveData<PagedList<FavMovies>> showMoviesPage(){
        return repository.loadMoviesFav();
    }

    public LiveData<PagedList<FavTv>> showTvPage(){
        return repository.loadTvFav();
    }
}

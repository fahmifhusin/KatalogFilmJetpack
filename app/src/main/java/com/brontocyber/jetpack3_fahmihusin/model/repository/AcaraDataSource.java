package com.brontocyber.jetpack3_fahmihusin.model.repository;

import androidx.lifecycle.LiveData;

import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;

import java.util.ArrayList;

public interface AcaraDataSource {
    LiveData<ArrayList<Acara>> getAllMovies();
    LiveData<ArrayList<Acara>> getAllTvShow();
    LiveData<Acara>getDetailMovie();
    LiveData<Acara>getDetailTvShow();
}

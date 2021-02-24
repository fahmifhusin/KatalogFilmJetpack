package com.brontocyber.jetpack3_fahmihusin.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.brontocyber.jetpack3_fahmihusin.model.repository.AcaraRepository;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;

import java.util.ArrayList;


public class AcaraViewModel extends ViewModel {

    private AcaraRepository repository;

    public AcaraViewModel(AcaraRepository repository) {
        this.repository = repository;
    }

    public LiveData<ArrayList<Acara>> viewMovies() {
        return repository.getAllMovies();
    }

    public LiveData<ArrayList<Acara>> viewTvShow() {
        return repository.getAllTvShow();
    }


}

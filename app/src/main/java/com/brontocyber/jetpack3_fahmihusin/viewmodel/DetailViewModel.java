package com.brontocyber.jetpack3_fahmihusin.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.brontocyber.jetpack3_fahmihusin.model.repository.AcaraRepository;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;

public class DetailViewModel extends ViewModel {

    private static String id;
    AcaraRepository repository;


    public DetailViewModel(AcaraRepository repository) {
        this.repository = repository;
    }

    public DetailViewModel() {

    }

    public LiveData<Acara> viewDetailMovies() {
        return repository.getDetailMovie();
    }

    public LiveData<Acara> viewDetailTv() {
        return repository.getDetailTvShow();
    }

    public void setIdAcara(String id){
        this.id = id;
    }

    public static String getIdAcara(){
        return id;
    }

}

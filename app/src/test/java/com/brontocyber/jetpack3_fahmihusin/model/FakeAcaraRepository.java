package com.brontocyber.jetpack3_fahmihusin.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavMovies;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavTv;
import com.brontocyber.jetpack3_fahmihusin.model.repository.LocalRepository;
import com.brontocyber.jetpack3_fahmihusin.utils.FakeDummyAcara;
import com.brontocyber.jetpack3_fahmihusin.model.repository.AcaraDataSource;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;

import java.util.ArrayList;

import static com.brontocyber.jetpack3_fahmihusin.ui.main.MainActivity.db;
import static com.brontocyber.jetpack3_fahmihusin.viewmodel.DetailViewModel.getIdAcara;
import static org.mockito.Mockito.mock;

public class FakeAcaraRepository implements AcaraDataSource {

    public FakeDummyAcara sourceData;
    public LocalRepository roomData;

    public FakeAcaraRepository(@NonNull FakeDummyAcara sourceData, LocalRepository roomData) {
        this.sourceData = sourceData;
        this.roomData = roomData;
    }



    @Override
    public LiveData<ArrayList<Acara>> getAllMovies() {
        MutableLiveData<ArrayList<Acara>> movieLiveData = new MutableLiveData<>();
        ArrayList<Acara> moviesResponse = sourceData.generateMoviesDummy();
        ArrayList<Acara> moviesList = new ArrayList<>();
        for (int i = 0; i < moviesResponse.size(); i++) {
            Acara response = moviesResponse.get(i);
            Acara dataMovie = new Acara(response.getId(),
                    response.getPoster_path(),
                    response.getTitle(),
                    response.getRelease_date(),
                    response.getOverview());
            moviesList.add(dataMovie);
        }
        movieLiveData.postValue(moviesList);
        return movieLiveData;
    }

    @Override
    public LiveData<ArrayList<Acara>> getAllTvShow() {
        MutableLiveData<ArrayList<Acara>>tvLiveData = new MutableLiveData<>();
        ArrayList<Acara> tvShowResponse = sourceData.generateTvDummy();
        ArrayList<Acara> tvShowList = new ArrayList<>();
        for (int i = 0; i < tvShowResponse.size(); i++) {
            Acara response = tvShowResponse.get(i);
            Acara dataMovie = new Acara(response.getId(),
                    response.getPoster_path(),
                    response.getTitle(),
                    response.getRelease_date(),
                    response.getOverview());
            tvShowList.add(dataMovie);
        }
        tvLiveData.postValue(tvShowList);
        return tvLiveData;
    }

    @Override
    public LiveData<Acara> getDetailMovie(){
        MutableLiveData<Acara>detailMovieLiveData = new MutableLiveData<>();
        detailMovieLiveData.postValue(sourceData.generateDetailMovie(getIdAcara()));
        return detailMovieLiveData;
    }

    @Override
    public LiveData<Acara> getDetailTvShow(){
        MutableLiveData<Acara>detailTvLiveData = new MutableLiveData<>();
        detailTvLiveData.postValue(sourceData.generateDetailTvShow(getIdAcara()));
        return detailTvLiveData;
    }

    public LiveData<PagedList<FavMovies>> loadMoviesFav(){
        return new LivePagedListBuilder<>(roomData.getLocalMovies(),3).build();
    }

    public LiveData<PagedList<FavTv>> loadTvFav(){
        return new LivePagedListBuilder<>(roomData.getLocalTv(),3).build();
    }

}

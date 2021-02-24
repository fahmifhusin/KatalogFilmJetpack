package com.brontocyber.jetpack3_fahmihusin.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavMovies;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavTv;
import com.brontocyber.jetpack3_fahmihusin.model.repository.AcaraRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
FavoriteViewModelTest:
Memuat Data Favorite Movies:
- Memanipulasi data ketika pemanggilan data favorite movies di kelas repository.
- Menambahkan Livedata
- setValue pada liveData
- Memastikan metode di kelas repository terpanggil.
- memasukan data favorite movies kedalam observer
- verifikasi data favorite movies telah di observe
Memuat Data Favorite Tv Show:
- Memanipulasi data ketika pemanggilan data favorite Tv show di kelas repository.
- Menambahkan LiveData
- setValue pada liveData
- Memastikan metode di kelas repository terpanggil.
- memasukan data favorite tv Show kedalam observer
- verifikasi data favorite tv Show telah di observe
*/

public class FavoriteViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private FavoriteViewModel viewModelTest;
    private AcaraRepository repositoryTest = mock(AcaraRepository.class);

    @Before
    public void setUp() {
        viewModelTest = new FavoriteViewModel(repositoryTest);
    }

    @Test
    public void showMoviesPageTest(){
        MutableLiveData<PagedList<FavMovies>> dummyFav = new MutableLiveData<>();
        PagedList<FavMovies> pagedList = mock(PagedList.class);
        dummyFav.setValue(pagedList);
        when(repositoryTest.loadMoviesFav()).thenReturn(dummyFav);
        Observer <PagedList<FavMovies>> observer = mock(Observer.class);
        viewModelTest.showMoviesPage().observeForever(observer);
        verify(observer).onChanged(pagedList);

    }

    @Test
    public void showTvShowPageTest(){
        MutableLiveData<PagedList<FavTv>> dummyFav = new MutableLiveData<>();
        PagedList<FavTv> pagedList = mock(PagedList.class);
        dummyFav.setValue(pagedList);
        when(repositoryTest.loadTvFav()).thenReturn(dummyFav);
        Observer <PagedList<FavTv>> observer = mock(Observer.class);
        viewModelTest.showTvPage().observeForever(observer);
        verify(observer).onChanged(pagedList);
    }

}
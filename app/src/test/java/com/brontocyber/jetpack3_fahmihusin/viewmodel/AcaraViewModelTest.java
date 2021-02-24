package com.brontocyber.jetpack3_fahmihusin.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.brontocyber.jetpack3_fahmihusin.model.repository.AcaraRepository;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;
import com.brontocyber.jetpack3_fahmihusin.helper.utils.DummyAcara;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
AcaraViewModelTest:
Memuat Data Movies:
- Memanipulasi data ketika pemanggilan data movies di kelas repository.
- Menambahkan Livedata
- setValue pada liveData
- Memastikan metode di kelas repository terpanggil.
- memasukan data movies kedalam observer
- verifikasi data movies telah di observe
Memuat Data Tv Show:
- Memanipulasi data ketika pemanggilan data Tv show di kelas repository.
- Menambahkan LiveData
- setValue pada liveData
- Memastikan metode di kelas repository terpanggil.
- memasukan data movies kedalam observer
- verifikasi data movies telah di observe
*/

public class AcaraViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private AcaraViewModel viewModelTest;
    private AcaraRepository repositoryTest = mock(AcaraRepository.class);

    @Before
    public void setUp() {
        viewModelTest = new AcaraViewModel(repositoryTest);
    }

    @Test
    public void viewMoviesTest() {
        ArrayList<Acara> dataMovies = DummyAcara.generateMoviesDummy();
        MutableLiveData<ArrayList<Acara>> liveMovies = new MutableLiveData<>();
        liveMovies.setValue(dataMovies);
        when(repositoryTest.getAllMovies()).thenReturn(liveMovies);
        Observer<ArrayList<Acara>> observer = mock(Observer.class);
        viewModelTest.viewMovies().observeForever(observer);
        verify(observer).onChanged(dataMovies);
    }

    @Test
    public void viewTvShowTest() {
        ArrayList dataTv = DummyAcara.generateTvDummy();
        MutableLiveData<ArrayList<Acara>> liveTv = new MutableLiveData<>();
        liveTv.setValue(dataTv);
        when(repositoryTest.getAllTvShow()).thenReturn(liveTv);
        Observer<ArrayList<Acara>> observer = mock(Observer.class);
        viewModelTest.viewTvShow().observeForever(observer);
        verify(observer).onChanged(dataTv);
    }


}
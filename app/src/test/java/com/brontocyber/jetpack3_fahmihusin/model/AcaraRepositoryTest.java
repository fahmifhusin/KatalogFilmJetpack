package com.brontocyber.jetpack3_fahmihusin.model;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;
import com.brontocyber.jetpack3_fahmihusin.helper.utils.DummyAcara;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavMovies;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavTv;
import com.brontocyber.jetpack3_fahmihusin.model.repository.LocalRepository;
import com.brontocyber.jetpack3_fahmihusin.utils.FakeDummyAcara;
import com.brontocyber.jetpack3_fahmihusin.utils.LiveDataTestUtils;
import com.brontocyber.jetpack3_fahmihusin.utils.PagedListUtil;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.DetailViewModel;
import com.bumptech.glide.load.engine.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.brontocyber.jetpack3_fahmihusin.ui.main.MainActivity.db;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/* AcaraRepositoryTest:
        Memuat Data Movies:
        - Memanipulasi data ketika pemanggilan data movies di kelas repository.
        -Memastikan data movies tidak null.
        -Memastikan jumlah data movies sesuai dengan yang diharapkan.
        Memuat Data Tv Show:
        - Memanipulasi data ketika pemanggilan data movies di kelas repository.
        -Memastikan data tv show tidak null.
        -Memastikan jumlah data tv show sesuai dengan yang diharapkan.
        Memuat Detail Movie:
        - Memanipulasi data ketika pemanggilan data movies di kelas repository.
        -Memastikan data detail movie show tidak null.
        Memuat Detail Tv Show:
        - Memanipulasi data ketika pemanggilan data movies di kelas repository.
        -Memastikan data detail tv show tidak null.
        Memuat Favorite Movies:
        - Memastikan metode di kelas repository terpanggil.
        - Memanipulasi data ketika pemanggilan data favorite movies di kelas repository.
        - Memastikan data favorite movies tidak null
        Memuat Favorite Tv Show:
        - Memastikan metode di kelas repository terpanggil.
        - Memanipulasi data ketika pemanggilan data favorite Tv Show di kelas repository.
        - Memastikan data favorite Tv Show tidak null.
        */


public class AcaraRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    public FakeAcaraRepository repository;
    public FakeDummyAcara remote = mock(FakeDummyAcara.class);
    public LocalRepository local = mock(LocalRepository.class);

    public ArrayList<Acara> moviesResponse = DummyAcara.generateMoviesDummy();
    public ArrayList<Acara> tvResponse = DummyAcara.generateTvDummy();

    public String moviesId = moviesResponse.get(0).getId();
    public String tvShowId = tvResponse.get(0).getId();


    @Before
    public void setUp() {
        repository = new FakeAcaraRepository(remote, local);
    }


    @Test
    public void getAllMoviesTest() {
        ArrayList<Acara> result = LiveDataTestUtils.getValue(repository.getAllMovies());
        assertNotNull(result);
        assertEquals(DummyAcara.generateMoviesDummy().size(), result.size());
    }

    @Test
    public void getAllTvShowTest() {
        ArrayList<Acara> result = LiveDataTestUtils.getValue(repository.getAllTvShow());
        assertNotNull(result);
        assertEquals(DummyAcara.generateTvDummy().size(), result.size());
    }

    @Test
    public void getDetailMoviesTest() {
        DetailViewModel model = new DetailViewModel();
        model.setIdAcara(moviesId);
        DummyAcara.generateDetailMovie(moviesId);
        Acara detailMovie = LiveDataTestUtils.getValue(repository.getDetailMovie());
        assertNotNull(detailMovie);
    }

    @Test
    public void getDetailTvShowTest() {
        DetailViewModel model = new DetailViewModel();
        model.setIdAcara(tvShowId);
        DummyAcara.generateDetailTvShow(tvShowId);
        Acara detailTv = LiveDataTestUtils.getValue(repository.getDetailTvShow());
        assertNotNull(detailTv);
    }

    @Test
    public void loadMoviesFavTest(){
        DataSource.Factory<Integer, FavMovies> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getLocalMovies()).thenReturn(dataSourceFactory);
        PagedList<FavMovies> result = PagedListUtil.mockPagedList(remote.loadFavMovie());
        repository.loadMoviesFav();
        verify(local).getLocalMovies();
        assertNotNull(result);
    }

    @Test
    public void loadTvFavTest(){
        DataSource.Factory<Integer, FavTv> dataSourceFactory = mock(DataSource.Factory.class);
        when(local.getLocalTv()).thenReturn(dataSourceFactory);
        PagedList<FavTv> result = PagedListUtil.mockPagedList(remote.loadFavTv());
        repository.loadTvFav();
        verify(local).getLocalTv();
        assertNotNull(result);
    }

}
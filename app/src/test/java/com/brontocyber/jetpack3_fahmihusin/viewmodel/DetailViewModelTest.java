package com.brontocyber.jetpack3_fahmihusin.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.brontocyber.jetpack3_fahmihusin.model.repository.AcaraRepository;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.brontocyber.jetpack3_fahmihusin.helper.utils.DummyAcara.IMAGE_URL;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
DetailViewModelTest:
Memuat Detail Movies:
- Memanipulasi data ketika pemanggilan data detail movies di kelas repository.
- Menambahkan Livedata
- setValue pada liveData
- Memastikan metode di kelas repository terpanggil.
- memasukan data movies kedalam observer
- verifikasi data movies telah di observe
Memuat data TvShow:
- Memanipulasi data ketika pemanggilan data detail tv show di kelas repository.
- Menambahkan LiveData
- setValue pada LiveData
- Memastikan metode di kelas repository terpanggil.
- memasukan data movies kedalam observer
- verifikasi data movies telah di observe
- Memastikan bahwa id acara bisa dimasukan.
- Memastikan bahwa id acara bisa didapatkan.
*/


public class DetailViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    protected Acara dummyMovie;
    protected Acara dummyTv;
    private DetailViewModel viewModel;
    private AcaraRepository repositoryTest = mock(AcaraRepository.class);

    @Before
    public void setUp() {
        viewModel = new DetailViewModel(repositoryTest);
        dummyMovie = new Acara("475557",
                IMAGE_URL + "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
                "Joker",
                "2019-10-02",
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.");

        dummyTv = new Acara(
                "1412",
                IMAGE_URL + "/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "Arrow",
                "2012-10-10",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.");
    }

    @Test
    public void viewDetailMoviesTest() {
        MutableLiveData<Acara> liveDetailMovie = new MutableLiveData<>();
        liveDetailMovie.setValue(dummyMovie);
        when(repositoryTest.getDetailMovie()).thenReturn(liveDetailMovie);
        Observer<Acara> observer = mock(Observer.class);
        viewModel.viewDetailMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovie);
    }

    @Test
    public void viewDetailTvTest() {
        MutableLiveData<Acara> liveDetailTv = new MutableLiveData<>();
        liveDetailTv.setValue(dummyTv);
        when(repositoryTest.getDetailTvShow()).thenReturn(liveDetailTv);
        Observer<Acara> observer = mock(Observer.class);
        viewModel.viewDetailTv().observeForever(observer);
        verify(observer).onChanged(dummyTv);
    }

    @Test
    public void setIdTest() {
        viewModel.setIdAcara("1");
    }

    @Test
    public void getIdTest() {
        DetailViewModel.getIdAcara();
    }
}

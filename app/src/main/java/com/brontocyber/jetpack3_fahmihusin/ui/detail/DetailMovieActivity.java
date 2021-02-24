package com.brontocyber.jetpack3_fahmihusin.ui.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.brontocyber.jetpack3_fahmihusin.helper.IdleResourceAcara;
import com.brontocyber.jetpack3_fahmihusin.R;
import com.brontocyber.jetpack3_fahmihusin.adapter.detail.DetailMoviesAdapter;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.DetailViewModel;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.ViewModelFactory;

public class DetailMovieActivity extends AppCompatActivity {
    RecyclerView rvDetail;
    DetailMoviesAdapter adapter;
    public static String idAcara;
    private String id;
    DetailViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movies);
        id = getIntent().getStringExtra(idAcara);
        //set adapter & data
        rvDetail = findViewById(R.id.rv_details);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvDetail.setLayoutManager(layoutManager);
        IdleResourceAcara.increment();
        //insert data from viewmodel
        viewModel = obtainViewModelDetail(this);
        viewModel.setIdAcara(id);
        viewModel.viewDetailMovies().observe(this, new Observer<Acara>() {
            @Override
            public void onChanged(Acara detailMovie) {
                adapter = new DetailMoviesAdapter(detailMovie);
                rvDetail.setAdapter(adapter);
                if (!IdleResourceAcara.getEspressoIdlingResource().isIdleNow()) {
                    IdleResourceAcara.decrement();
                }
            }
        });

    }

    @NonNull
    private static DetailViewModel obtainViewModelDetail(DetailMovieActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance();
        return ViewModelProviders.of(activity, factory).get(DetailViewModel.class);
    }
}

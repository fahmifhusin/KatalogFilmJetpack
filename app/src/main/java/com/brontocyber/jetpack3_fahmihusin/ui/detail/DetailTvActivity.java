package com.brontocyber.jetpack3_fahmihusin.ui.detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.brontocyber.jetpack3_fahmihusin.helper.IdleResourceAcara;
import com.brontocyber.jetpack3_fahmihusin.R;
import com.brontocyber.jetpack3_fahmihusin.adapter.detail.DetailMoviesAdapter;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.DetailViewModel;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.ViewModelFactory;

public class DetailTvActivity extends AppCompatActivity {
    RecyclerView rvDetail;
    DetailMoviesAdapter adapter;
    public static String idTv;
    private String id;
    DetailViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);
        id = getIntent().getStringExtra(idTv);
        //set adapter & data
        rvDetail = findViewById(R.id.rv_details_tv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvDetail.setLayoutManager(layoutManager);
        IdleResourceAcara.increment();
        //insert data from viewmodel
        viewModel = obtainViewModelDetail(this);
        viewModel.setIdAcara(id);
        viewModel.viewDetailTv().observe(this, new Observer<Acara>() {
            @Override
            public void onChanged(Acara detailTv) {
                adapter = new DetailMoviesAdapter(detailTv);
                rvDetail.setAdapter(adapter);
                if (!IdleResourceAcara.getEspressoIdlingResource().isIdleNow()) {
                    IdleResourceAcara.decrement();
                }
            }
        });

    }

    @NonNull
    private static DetailViewModel obtainViewModelDetail(DetailTvActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance();
        return ViewModelProviders.of(activity, factory).get(DetailViewModel.class);

    }
}

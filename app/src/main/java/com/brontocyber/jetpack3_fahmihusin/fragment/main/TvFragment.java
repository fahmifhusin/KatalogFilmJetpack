package com.brontocyber.jetpack3_fahmihusin.fragment.main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.brontocyber.jetpack3_fahmihusin.helper.IdleResourceAcara;
import com.brontocyber.jetpack3_fahmihusin.R;
import com.brontocyber.jetpack3_fahmihusin.adapter.main.TvAdapter;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.AcaraViewModel;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.ViewModelFactory;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {

    private RecyclerView rvTvShow;
    private AcaraViewModel viewModel;

    public TvFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        inflater.inflate(R.layout.fragment_movies, container, false);
        //add view model
        viewModel = obtainViewModel(this);
        //set adapter & data
        rvTvShow = view.findViewById(R.id.rv_tvshow);
        rvTvShow.setHasFixedSize(true);
        rvTvShow.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        IdleResourceAcara.increment();
        //insert viewmodel to adapter
        viewModel.viewTvShow().observe(this, new Observer<ArrayList<Acara>>() {
            @Override
            public void onChanged(ArrayList<Acara> data) {
                TvAdapter listTv = new TvAdapter(data);
                rvTvShow.setAdapter(listTv);
                if (!IdleResourceAcara.getEspressoIdlingResource().isIdleNow()) {
                    IdleResourceAcara.decrement();
                }
            }
        });


        return view;
    }

    @NonNull
    private static AcaraViewModel obtainViewModel(Fragment fragment) {
        ViewModelFactory factory = ViewModelFactory.getInstance();
        return ViewModelProviders.of(fragment, factory).get(AcaraViewModel.class);
    }

}

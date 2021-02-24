package com.brontocyber.jetpack3_fahmihusin.fragment.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brontocyber.jetpack3_fahmihusin.helper.IdleResourceAcara;
import com.brontocyber.jetpack3_fahmihusin.R;
import com.brontocyber.jetpack3_fahmihusin.adapter.main.MoviesAdapter;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.AcaraViewModel;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.ViewModelFactory;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private RecyclerView rvMovies;
    private AcaraViewModel viewModel;

    public MoviesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        //add view model
        viewModel = obtainViewModel(this);
        //set adapter & data

        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        IdleResourceAcara.increment();
        //insert viewmodel to adapter
        viewModel.viewMovies().observe(this, new Observer<ArrayList<Acara>>() {
            @Override
            public void onChanged(ArrayList<Acara> data) {
                MoviesAdapter listMovies = new MoviesAdapter(data);
                rvMovies.setAdapter(listMovies);
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

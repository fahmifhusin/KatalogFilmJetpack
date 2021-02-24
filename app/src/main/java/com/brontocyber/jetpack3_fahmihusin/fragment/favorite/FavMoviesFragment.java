package com.brontocyber.jetpack3_fahmihusin.fragment.favorite;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.brontocyber.jetpack3_fahmihusin.R;
import com.brontocyber.jetpack3_fahmihusin.adapter.favorite.PagedMoviesAdapter;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavMovies;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.FavoriteViewModel;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.ViewModelFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavMoviesFragment extends Fragment {

    RecyclerView rv;
    PagedMoviesAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    FavoriteViewModel viewModel;


    public FavMoviesFragment() {
        // Required empty public constructor
    }

    @NonNull
    private static FavoriteViewModel obtainViewModel(Fragment fragment) {
        ViewModelFactory factory = ViewModelFactory.getInstance();
        return ViewModelProviders.of(fragment, factory).get(FavoriteViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav_movies, container, false);
        // Inflate the layout for this fragment
        layoutManager = new LinearLayoutManager(this.getContext());
        rv = view.findViewById(R.id.rv_fav_movies);
        rv.setLayoutManager(layoutManager);
        viewModel = obtainViewModel(this);
        viewModel.showMoviesPage().observe(this, new Observer<PagedList<FavMovies>>() {
            @Override
            public void onChanged(PagedList<FavMovies> favMovies) {
                adapter = new PagedMoviesAdapter(getActivity());
                adapter.submitList(favMovies);
                rv.setAdapter(adapter);
            }
        });
        return view;
    }

}

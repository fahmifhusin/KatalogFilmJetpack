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
import com.brontocyber.jetpack3_fahmihusin.adapter.favorite.PagedTvAdapter;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.FavTv;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.FavoriteViewModel;
import com.brontocyber.jetpack3_fahmihusin.viewmodel.ViewModelFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavTvFragment extends Fragment {

    RecyclerView rv;
    PagedTvAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    FavoriteViewModel viewModel;


    public FavTvFragment() {
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
        View view = inflater.inflate(R.layout.fragment_fav_tv, container, false);
        // Inflate the layout for this fragment
        layoutManager = new LinearLayoutManager(this.getContext());
        rv = view.findViewById(R.id.rv_fav_tv);
        rv.setLayoutManager(layoutManager);
        viewModel = obtainViewModel(this);
        viewModel.showTvPage().observe(this, new Observer<PagedList<FavTv>>() {
            @Override
            public void onChanged(PagedList<FavTv> favTvs) {
                adapter = new PagedTvAdapter(getActivity());
                adapter.submitList(favTvs);
                rv.setAdapter(adapter);
            }
        });
        return view;
    }

}

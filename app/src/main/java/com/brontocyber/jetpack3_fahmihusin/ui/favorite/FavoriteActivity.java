package com.brontocyber.jetpack3_fahmihusin.ui.favorite;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.brontocyber.jetpack3_fahmihusin.R;
import com.brontocyber.jetpack3_fahmihusin.fragment.favorite.FavMoviesFragment;
import com.brontocyber.jetpack3_fahmihusin.fragment.favorite.FavTvFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FavoriteActivity extends AppCompatActivity {
    public static String STATUS = "status";
    private final String SELECTED_MENU = "selected_menu";
    protected FragmentManager fragmentManager;
    private Fragment fragment;
    private BottomNavigationView navFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        Toolbar toolbar = findViewById(R.id.toolbar_fav);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getResources().getString(R.string.favorite));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        navFav = findViewById(R.id.nav_view_fav);
        //set default fragment
        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU);
        } else {
            navFav.setSelectedItemId(R.id.action_movies);
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container_fav, new FavMoviesFragment()).commit();

        }
        navFav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_movies:
                    fragment = new FavMoviesFragment();
                    Log.d(STATUS, String.valueOf(item.getTitle()));
                    break;
                case R.id.action_tv_show:
                    fragment = new FavTvFragment();
                    Log.d(STATUS, String.valueOf(item.getTitle()));
                    break;
            }
            if (fragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .replace(R.id.container_fav, fragment)
                        .commit();
            }
            return true;
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_MENU, navFav.getSelectedItemId());
        Log.d("id", String.valueOf(navFav.getSelectedItemId()));
    }
}

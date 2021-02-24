package com.brontocyber.jetpack3_fahmihusin.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import com.brontocyber.jetpack3_fahmihusin.R;
import com.brontocyber.jetpack3_fahmihusin.fragment.main.MoviesFragment;
import com.brontocyber.jetpack3_fahmihusin.fragment.main.TvFragment;
import com.brontocyber.jetpack3_fahmihusin.model.local.AcaraDB;
import com.brontocyber.jetpack3_fahmihusin.ui.favorite.FavoriteActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static String STATUS = "status";
    public static AcaraDB db;
    private final String SELECTED_MENU = "selected_menu";
    protected FragmentManager fragmentManager;
    private Fragment fragment;
    private BottomNavigationView navView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_movies:
                    fragment = new MoviesFragment();
                    Log.d(STATUS, String.valueOf(item.getTitle()));
                    break;
                case R.id.action_tv_show:
                    fragment = new TvFragment();
                    Log.d(STATUS, String.valueOf(item.getTitle()));
                    break;
            }
            if (fragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .replace(R.id.container, fragment)
                        .commit();
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //end
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.app_title));
        }
        navView = findViewById(R.id.nav_view);
        //set default fragment
        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU);
        } else {
            navView.setSelectedItemId(R.id.action_movies);
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, new MoviesFragment()).commit();

        }
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        db = Room.databaseBuilder(this.getApplicationContext(),
                AcaraDB.class, "movie_catalogue").allowMainThreadQueries().build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fav_item:
                Intent mFavIntent = new Intent(this, FavoriteActivity.class);
                startActivity(mFavIntent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_MENU, navView.getSelectedItemId());
        Log.d("id", String.valueOf(navView.getSelectedItemId()));
    }
}

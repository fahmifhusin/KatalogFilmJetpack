package com.brontocyber.jetpack3_fahmihusin;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.brontocyber.jetpack3_fahmihusin.helper.IdleResourceAcara;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;
import com.brontocyber.jetpack3_fahmihusin.ui.detail.DetailMovieActivity;
import com.brontocyber.jetpack3_fahmihusin.utils.DebugDummyAcara;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/*
*DetailMovieActivityTest:
*Memuat detail movie:
*Register Idle Resource saat memuat data
*Unregister Idle Resource setelah memuat data
-Membuka halaman DetailMovieActivity.
-Memastikan ImageView untuk poster sudah tampil.
-Memastikan TextView untuk title sudah tampil.
-Memastikan value dari title sesuai dengan yang diharapkan.
-Memastikan TextView untuk release date sudah tampil.
-Memastikan value dari release date sesuai dengan yang diharapkan.
-Memastikan TextView untuk overview sudah tampil.
-Memastikan value dari overview sesuai dengan yang diharapkan.
*/


public class DetailMovieActivityTest {
    private Acara dataDetailMovie = DebugDummyAcara.generateMoviesDummy().get(0);

    @Rule
    public ActivityTestRule<DetailMovieActivity> activityRule = new ActivityTestRule<DetailMovieActivity>(DetailMovieActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailMovieActivity.class);
            result.putExtra(DetailMovieActivity.idAcara, dataDetailMovie.getId());
            return result;
        }
    };

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(IdleResourceAcara.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(IdleResourceAcara.getEspressoIdlingResource());
    }


    @Test
    public void loadDetailMovie() {
        onView(withId(R.id.detail_gambar)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_judul)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_judul)).check(matches(withText(dataDetailMovie.getTitle())));
        onView(withId(R.id.detail_rilis)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_rilis)).check(matches(withText(dataDetailMovie.getRelease_date())));
        onView(withId(R.id.detail_deskripsi)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_deskripsi)).check(matches(withText(dataDetailMovie.getOverview())));
    }
}
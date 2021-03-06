package com.brontocyber.jetpack3_fahmihusin.fragment;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import com.brontocyber.jetpack3_fahmihusin.fragment.main.MoviesFragment;
import com.brontocyber.jetpack3_fahmihusin.helper.IdleResourceAcara;
import com.brontocyber.jetpack3_fahmihusin.R;
import com.brontocyber.jetpack3_fahmihusin.testing.DummyFragmentActivity;
import com.brontocyber.jetpack3_fahmihusin.utils.DebugRecyclerView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/*
* Skenario MoviesFragmentTest :
* Memuat Data Movies:
*Register Idle Resource saat memuat data
*Unregister Idle Resource setelah memuat data
 -Membuka halaman MoviesFragment.
 -Memastikan RecyclerView dalam keadaan tampil.
 -Memastikan jumlah item RecyclerView sesuai dengan yang diharapkan.
*/

public class MoviesFragmentTest {

    @Rule
    public ActivityTestRule<DummyFragmentActivity> activityRule = new ActivityTestRule<>(DummyFragmentActivity.class);
    private MoviesFragment moviesFragment = new MoviesFragment();

    @Before
    public void setUp() {
        activityRule.getActivity().setFragment(moviesFragment);
        IdlingRegistry.getInstance().register(IdleResourceAcara.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(IdleResourceAcara.getEspressoIdlingResource());
    }

    @Test
    public void testMoviesFragment() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).check(new DebugRecyclerView(12));
    }

}
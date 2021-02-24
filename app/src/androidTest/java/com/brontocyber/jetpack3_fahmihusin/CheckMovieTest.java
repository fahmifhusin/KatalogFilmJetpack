package com.brontocyber.jetpack3_fahmihusin;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.brontocyber.jetpack3_fahmihusin.helper.IdleResourceAcara;
import com.brontocyber.jetpack3_fahmihusin.ui.main.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/*
*CheckMovieTest:
*Memuat halaman MainActivity:
*Register Idle Resource saat memuat data
*Unregister Idle Resource setelah memuat data
-Memastikan RecyclerView sudah tampil.
-Memberi aksi klik di item pertama RecyclerView.
-Memastikan RecyclerView sudah tampil.
-Memberi aksi klik di item kedua RecyclerView.
-Memastikan RecyclerView sudah tampil.
-Memberi aksi klik di item ketiga RecyclerView.
-Memastikan RecyclerView sudah tampil.
-Memberi aksi klik di item keempat RecyclerView.
-Memastikan RecyclerView sudah tampil.
-Memberi aksi klik di item kelima RecyclerView.
-Memastikan RecyclerView sudah tampil.
-Memberi aksi klik di item keenam RecyclerView.
-Memastikan RecyclerView sudah tampil.
-Memberi aksi klik di item ketujuh RecyclerView.
-Memastikan RecyclerView sudah tampil.
-Memberi aksi klik di item kedelapan RecyclerView.
-Memastikan RecyclerView sudah tampil.
-Memberi aksi klik di item kesembilan RecyclerView.
-Memastikan RecyclerView sudah tampil.
-Memberi aksi klik di item kesepuluh RecyclerView.
-Memastikan RecyclerView sudah tampil.
-Memberi aksi klik di item kesebelas RecyclerView.
-Memastikan RecyclerView sudah tampil.
-Memberi aksi klik di item keduabelas RecyclerView.
*/

public class CheckMovieTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(IdleResourceAcara.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(IdleResourceAcara.getEspressoIdlingResource());
    }

    @Test
    public void indexElevenTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(11, click()));
    }

    @Test
    public void indexTenTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(10, click()));
    }

    @Test
    public void indexNineTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(9, click()));
    }

    @Test
    public void indexEightTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(8, click()));
    }

    @Test
    public void indexSevenTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(7, click()));
    }

    @Test
    public void indexSixTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(6, click()));
    }

    @Test
    public void indexFiveTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(5, click()));
    }

    @Test
    public void indexFourTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(4, click()));
    }

    @Test
    public void indexThreeTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
    }

    @Test
    public void indexTwoTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));

    }

    @Test
    public void indexOneTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

    }

    @Test
    public void indexZeroTest() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

    }
}

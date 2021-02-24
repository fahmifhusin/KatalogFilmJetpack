package com.brontocyber.jetpack3_fahmihusin;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.brontocyber.jetpack3_fahmihusin.helper.IdleResourceAcara;
import com.brontocyber.jetpack3_fahmihusin.model.local.entity.Acara;
import com.brontocyber.jetpack3_fahmihusin.ui.detail.DetailTvActivity;
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

/*DetailTvActivityTest:
 *Memuat detail Tv Show:
 *Register Idle Resource saat memuat data
 *Unregister Idle Resource setelah memuat data
 -Membuka halaman DetailTvActivity.
 -Memastikan ImageView untuk poster sudah tampil.
 -Memastikan TextView untuk title sudah tampil.
 -Memastikan value dari title sesuai dengan yang diharapkan.
 -Memastikan TextView untuk release date sudah tampil.
 -Memastikan value dari release date sesuai dengan yang diharapkan.
 -Memastikan TextView untuk overview sudah tampil.
 -Memastikan value dari overview sesuai dengan yang diharapkan.
 */

public class DetailTvActivityTest {
    private Acara dataDetailTv = DebugDummyAcara.generateTvDummy().get(0);

    @Rule
    public ActivityTestRule<DetailTvActivity> activityRule = new ActivityTestRule<DetailTvActivity>(DetailTvActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailTvActivity.class);
            result.putExtra(DetailTvActivity.idTv, dataDetailTv.getId());
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
        onView(withId(R.id.detail_judul)).check(matches(withText(dataDetailTv.getTitle())));
        onView(withId(R.id.detail_rilis)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_rilis)).check(matches(withText(dataDetailTv.getRelease_date())));
        onView(withId(R.id.detail_deskripsi)).check(matches(isDisplayed()));
        onView(withId(R.id.detail_deskripsi)).check(matches(withText(dataDetailTv.getOverview())));
    }
}
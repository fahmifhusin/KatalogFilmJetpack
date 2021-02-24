package com.brontocyber.jetpack3_fahmihusin.helper;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;

public class IdleResourceAcara {
    private static final String RESOURCE = "GLOBAL";
    private static CountingIdlingResource espressoTestIdlingResource = new CountingIdlingResource(RESOURCE);

    public static void increment() {
        espressoTestIdlingResource.increment();
    }

    public static void decrement() {
        espressoTestIdlingResource.decrement();
    }

    public static IdlingResource getEspressoIdlingResource() {
        return espressoTestIdlingResource;
    }
}
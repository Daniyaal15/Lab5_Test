package com.example.lab5;

import static org.junit.Assert.*;

import android.app.Activity;
import android.view.View;

import androidx.annotation.ContentView;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityActivityTestRule.getActivity();
    }

    @Test
    public void testActivity() {
        View listView = mainActivity.findViewById(R.id.currency_list_view);
        assertNotNull(listView);
    }


    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}
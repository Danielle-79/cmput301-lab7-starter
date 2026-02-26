package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ShowActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> scenario =
            new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void testActivitySwitch() {

        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name))
                .perform(typeText("Calgary"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withText("Calgary")).perform(click());

        onView(withId(R.id.text_city_name))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testCityNameConsistency() {

        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name))
                .perform(typeText("Toronto"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withText("Toronto")).perform(click());

        onView(withId(R.id.text_city_name))
                .check(matches(withText("Toronto")));
    }

    @Test
    public void testBackButton() {

        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name))
                .perform(typeText("Montreal"));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withText("Montreal")).perform(click());

        onView(withId(R.id.button_back)).perform(click());

        onView(withId(R.id.button_add))
                .check(matches(isDisplayed()));
    }
}

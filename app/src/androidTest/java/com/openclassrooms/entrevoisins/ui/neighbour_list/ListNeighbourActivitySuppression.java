package com.openclassrooms.entrevoisins.ui.neighbour_list;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.openclassrooms.entrevoisins.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ListNeighbourActivitySuppression {

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule =
            new ActivityTestRule<>(ListNeighbourActivity.class);

    @Test
    public void listNeighbourActivitySuppression() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.list_neighbours),
                        withParent(withId(R.id.container))));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.favoriteButton), withContentDescription("Favorites"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.linearLayout),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.backButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.linearLayout),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction tabView = onView(
                allOf(withContentDescription("Favorites"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction viewPager = onView(
                allOf(withId(R.id.container),
                        childAtPosition(
                                allOf(withId(R.id.main_content),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        viewPager.perform(swipeLeft());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.list_neighbours_favorite),
                        withParent(withId(R.id.container))));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.favoriteButton), withContentDescription("Favorites"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.linearLayout),
                                        0),
                                3),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.backButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.linearLayout),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.list_neighbours_favorite),
                        withParent(allOf(withId(R.id.container),
                                withParent(withId(R.id.main_content)))),
                        isDisplayed()));
        recyclerView3.check(withItemCount(0));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

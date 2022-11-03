package com.openclassrooms.entrevoisins.utils;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;

import com.openclassrooms.entrevoisins.R;

import org.hamcrest.Matcher;

public class FavoriteActions implements ViewAction {
    @Override
    public Matcher<View> getConstraints() {
        return null;
    }

    @Override
    public String getDescription() {
        return "0penView";
    }

    @Override
    public void perform(UiController uiController, View view) {
        View button = view.findViewById(R.id.favoriteButton);
        // Maybe check for null
        button.performClick();
    }
}

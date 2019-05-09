package com.example.rhuarhri.thestablemarrageproblem;

import android.content.Context;
//import android.support.test.InstrumentationRegistry;
//import android.support.test.runner.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import androidx.test.runner.AndroidJUnitRunner;

import android.graphics.Point;
import android.os.RemoteException;
import android.view.View;


import androidx.test.espresso.Espresso;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {


    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void UITest()
    {

        //project 1
        String projectName = "text to speech app";
        List<String> projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("natural language processing");
        projectTopics.add("app development");
        projectTopics.add("UI design");

        addProject(projectName, projectTopics);

        //project 2
        projectName = "home smart lock";
        projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("IOT");
        projectTopics.add("cyber security");
        projectTopics.add("app development");

        addProject(projectName, projectTopics);

        String expected = "\nProject text to speech app is paired with  lecturer DR Brown.\n"+
                            "Project home smart lock is paired with  lecturer DR Robinson.";
        onView(withId(R.id.resultsDisplayTXT)).check(matches(withText(expected)));

    }

    private void addProject(String name, List<String> topics)
    {
        onView(withId(R.id.projectNameET)).perform(typeText(name), closeSoftKeyboard());

        for (int i = 0; i < topics.size(); i++)
        {
            onView(withId(R.id.projectTopicsET)).perform(typeText(topics.get(i)), closeSoftKeyboard());
            onView(withId(R.id.addTopicBTN)).perform(click());
        }

        onView(withId(R.id.saveProjectBTN)).perform(click());
    }
}

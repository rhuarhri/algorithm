package com.example.rhuarhri.thestablemarrageproblem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import com.example.rhuarhri.thestablemarrageproblem.algorithm;
import com.example.rhuarhri.thestablemarrageproblem.lecturer;
import com.example.rhuarhri.thestablemarrageproblem.project;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

/*
HOW THE PROGRAM WORKS
The program is design to match a student's final year project
with a lecture.

A student will input there final year project idea
and the program will try and match it with a lecturer


The program will use an algorithm called the stable marriage algorithm
created by Gale and Shapley.

How the algorithm works

final year projects
A: big data algorithm
B: android app
C:artificial neural network

lecturers
1:Dr Smith specialises in {android apps, artificial neural network, big data algorithms}
2:Dr Cook specialises in {android apps, big data algorithms, artificial neural network}
3:Dr Sculthorpe specialises in (artificial neural network, big data algorithms, android apps}

Step 1 Dr smith gets the first FYP in the list which is A even through it is not
what he wants.
Step 2 Dr Cook see that she is better at big data algorithms so takes A from Dr Smith
Step 3 Dr Sculthorpe is not any better at big data algorithms when compared to Dr Cook
Step 4 Dr smith get the next FYP in the list which is B and is something that he is very familiar
with
Step 5 Dr Cook wants project B but is not any better at android apps compared to Dr Smith
so does not take the project from him.
Step 6 Dr Sculthorpe is does not understand android apps as well as Dr Smith does so does
nothing.
Step 7 Dr Smith gets the last FYP in the list he better at his current project so leaves
this project alone.
Step 8 Dr Cook does the same thing as Dr Smith
Step 9 Dr Sculthorpe does not have a project so accepts it good thing it is
something he knows a lot about.


This is repeated with every final year project
which gets this result
Dr Smith = android app project
Dr Cook = big data algorithm
Dr Sculthorpe = artificial neural network

Things to think about
What happens when if the algorithm does not
find a match?

Should the algorithm be repeated so that
the final year projects pick the lecture as
this might create a better match?


 */


public class ExampleUnitTest {




    private List<project> basicProjectInput()
    {
        List<project> projects = new ArrayList<project>();
        project finalYearProject = new project();

        finalYearProject.setName("app based home automation");
        List<String> topics = new ArrayList<String>();
        topics.add("mobile app");
        topics.add("home automation");
        finalYearProject.setCoveredTopics(topics);
        List<String> requirements = new ArrayList<String>();
        requirements.add("android studio");
        requirements.add("mobile device");
        requirements.add("sensors");


        projects.add(finalYearProject);



        return projects;
    }

    private List<lecturer> basicLecturerInput()
    {
        List<lecturer> lecturers = new ArrayList<lecturer>();
        lecturer availableLecturer = new lecturer();

        availableLecturer.setName("Dr Smith");
        List<String> interestedIn = new ArrayList<String>();
        interestedIn.add("mobile app");
        interestedIn.add("home automation");
        availableLecturer.setAreasOfInterest(interestedIn);
        List<String> canHelpWith = new ArrayList<String>();
        canHelpWith.add("android studio");
        canHelpWith.add("mobile device");
        canHelpWith.add("sensors");
        availableLecturer.setCanHelpWith(canHelpWith);


        lecturers.add(availableLecturer);

        return lecturers;
    }


    /*
    @Test
    public void normalInput()
    {
        //The algorithm should be able to successfully match this input

        algorithm test = new algorithm(basicProjectInput(), basicLecturerInput());

        String lecturerName = test.pair("project");

        String expected = null;
        String result = lecturerName;

        assertNotEquals(expected, result);

        //TODO
        /*
        Depending on how the algorithm is used it may create different results
        The bestFor parameter is there to exploit that.
        Who it can get different results
        For example if the algorithm match project with lecturer based on what the lecturer
        wants then the result will benefit the lecturer.

        This may need to be managed later in the program as there could be one result that
        could be better than the other.

         *//*
    }*/

    @Test
    public void calculatePreferenceTest()
    {


        algorithm test = new algorithm(basicProjectInput(), basicLecturerInput());

        String projectWantsLecturerWith = "home automation";

        List<String> lecturerInterestedIn = new ArrayList<String>();

        lecturerInterestedIn.add("games development");
        lecturerInterestedIn.add("home automation");



        int result = test.preferenceCalculator(lecturerInterestedIn, projectWantsLecturerWith);

        int expected = 1;

        assertEquals(expected, result);

    }

    @Test
    public void calculatePreferenceTestNoMatchFound()
    {
        algorithm test = new algorithm(basicProjectInput(), basicLecturerInput());

        String projectWantsLecturerWith = "app development";

        List<String> lecturerInterestedIn = new ArrayList<String>();

        lecturerInterestedIn.add("games development");
        lecturerInterestedIn.add("home automation");

        int result = test.preferenceCalculator(lecturerInterestedIn, projectWantsLecturerWith);

        int expected = 0;

        assertEquals(expected, result);
    }

    @Test
    public void comparePossibleMatches()
    {
        algorithm test = new algorithm(basicProjectInput(), basicLecturerInput());

        List<String> projectPreferences = new ArrayList<String>();
        projectPreferences.add("home automation");
        projectPreferences.add("games development");

        String optionOneID = "dave";
        List<String> optionOnePreferences = new ArrayList<String>();
        optionOnePreferences.add("home automation");
        optionOnePreferences.add("games development");

        String optionTwoID = "fred";
        List<String> optionTwoPreferences = new ArrayList<String>();
        optionTwoPreferences.add("home automation");
        optionTwoPreferences.add("big data algorithms");


        String result =
                test.compareTwoPossibleMatches(projectPreferences, optionOneID, optionTwoPreferences,
                        optionTwoID, optionTwoPreferences);

        String expected = "dave";

        assertEquals(expected, result);
    }

    @Test
    public void comparePossibleMatchesBothOptionEqual()
    {
        algorithm test = new algorithm(basicProjectInput(), basicLecturerInput());

        List<String> projectPreferences = new ArrayList<String>();
        projectPreferences.add("home automation");
        projectPreferences.add("games development");

        String optionOneID = "dave";
        List<String> optionOnePreferences = new ArrayList<String>();
        optionOnePreferences.add("home automation");
        optionOnePreferences.add("games development");

        String optionTwoID = "fred";
        List<String> optionTwoPreferences = new ArrayList<String>();
        optionTwoPreferences.add("home automation");
        optionTwoPreferences.add("games development");


        String result =
                test.compareTwoPossibleMatches(projectPreferences, optionOneID, optionTwoPreferences,
                        optionTwoID, optionTwoPreferences);

        String expected = "dave";

        assertEquals(expected, result);
    }


}
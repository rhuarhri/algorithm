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



public class ExampleUnitTest {

    @Test
    public void calculatePreferenceTest()
    {

        algorithm test = new algorithm(false, false);

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
        algorithm test = new algorithm(false, false);

        String projectWantsLecturerWith = "app development";

        List<String> lecturerInterestedIn = new ArrayList<String>();

        lecturerInterestedIn.add("games development");
        lecturerInterestedIn.add("home automation");

        int result = test.preferenceCalculator(lecturerInterestedIn, projectWantsLecturerWith);

        int expected = 0;

        assertEquals(expected, result);
    }

    @Test
    public void wrongSetup()
    {
        String result = "";
        try {
            algorithm test = new algorithm(true, true);
        }
        catch (Exception e)
        {
            result = e.getMessage();
        }

        String expected = "Cannot have bias towards both.";

        /*
        The user should not be able to specify a bias that applies both lectures and projects
         */

        assertEquals(expected, result);
    }

    @Test
    public void matchResultsBiasIsBestFit()
    {
        algorithm test = new algorithm(false, false);

        String projectName = "text to speech app";
        List<String> projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("natural language processing");
        projectTopics.add("app development");
        projectTopics.add("UI design");

        test.addProject(projectName, projectTopics);

        projectName = "home smart lock";
        projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("IOT");
        projectTopics.add("cyber security");
        projectTopics.add("app development");

        test.addProject(projectName, projectTopics);

        String lecturerName = "Dr Brown";
        List<String> lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("natural language processing");
        lecturerInterests.add("app development");
        lecturerInterests.add("IOT");

        test.addLecture(lecturerName, lecturerInterests);

        lecturerName = "Dr Robinson";
        lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("cyber security");
        lecturerInterests.add("IOT");
        lecturerInterests.add("UI design");

        test.addLecture(lecturerName, lecturerInterests);


        test.matching();

        List<String> results = test.displayResults();

        String result = results.get(0);
        String expected = "Project " + "text to speech app" + " is paired with "
                + " lecturer " + "Dr Brown"+ ".";

        assertEquals(expected, result);

    }

    @Test
    public void matchResultsBiasIsLecturer()
    {
        algorithm test = new algorithm(true, false);

        String projectName = "text to speech app";
        List<String> projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("natural language processing");
        projectTopics.add("app development");
        projectTopics.add("UI design");

        test.addProject(projectName, projectTopics);

        projectName = "home smart lock";
        projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("IOT");
        projectTopics.add("cyber security");
        projectTopics.add("app development");

        test.addProject(projectName, projectTopics);

        String lecturerName = "Dr Brown";
        List<String> lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("app development");
        lecturerInterests.add("UI design");
        lecturerInterests.add("IOT");

        test.addLecture(lecturerName, lecturerInterests);

        lecturerName = "Dr Robinson";
        lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("cyber security");
        lecturerInterests.add("IOT");
        lecturerInterests.add("UI design");

        test.addLecture(lecturerName, lecturerInterests);


        test.matching();

        List<String> results = test.displayResults();

        String result = results.get(0);
        String expected = "Project " + "text to speech app" + " is paired with "
                + " lecturer " + "Dr Brown"+ ".";

        assertEquals(expected, result);


    }

    @Test
    public void matchResultBiasIsProject()
    {
        algorithm test = new algorithm(false, true);

        String projectName = "text to speech app";
        List<String> projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("natural language processing");
        projectTopics.add("app development");
        projectTopics.add("UI design");

        test.addProject(projectName, projectTopics);

        projectName = "home smart lock";
        projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("IOT");
        projectTopics.add("cyber security");
        projectTopics.add("app development");

        test.addProject(projectName, projectTopics);

        String lecturerName = "Dr Brown";
        List<String> lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("IOT");
        lecturerInterests.add("natural language processing");
        lecturerInterests.add("app development");


        test.addLecture(lecturerName, lecturerInterests);

        lecturerName = "Dr Robinson";
        lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("cyber security");
        lecturerInterests.add("IOT");
        lecturerInterests.add("UI design");

        test.addLecture(lecturerName, lecturerInterests);


        test.matching();

        List<String> results = test.displayResults();

        String result = results.get(0);
        String expected = "Project " + "text to speech app" + " is paired with "
                + " lecturer " + "Dr Brown"+ ".";

        assertEquals(expected, result);

    }

    @Test
    public void calculateTotalPreferences()
    {
        List<String> projectTopics = new ArrayList<String>();
        List<String> lectureInterests = new ArrayList<String>();

        projectTopics.add("AI");
        projectTopics.add("VR");
        projectTopics.add("UX design");

        lectureInterests.add("AI");
        lectureInterests.add("UI design");
        lectureInterests.add("VR");

        algorithm test = new algorithm(false, false);

        int expected = 4;
        int result = test.totalPreference(projectTopics, lectureInterests);

        assertEquals(expected, result);
    }


    @Test
    public void MoreProjectsThanLecturers()
    {

        algorithm test = new algorithm(false, false);

        //project 1
        String projectName = "text to speech app";
        List<String> projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("natural language processing");
        projectTopics.add("app development");
        projectTopics.add("UI design");

        test.addProject(projectName, projectTopics);

        //project 2
        projectName = "home smart lock";
        projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("IOT");
        projectTopics.add("cyber security");
        projectTopics.add("app development");

        test.addProject(projectName, projectTopics);

        //project 3
        projectName = "game based education in VR";
        projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("VR");
        projectTopics.add("games development");
        projectTopics.add("UI design");

        test.addProject(projectName, projectTopics);

        //lecturer 1
        String lecturerName = "Dr Brown";
        List<String> lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("natural language processing");
        lecturerInterests.add("app development");
        lecturerInterests.add("IOT");

        test.addLecture(lecturerName, lecturerInterests);

        //lecturer 2
        lecturerName = "Dr Robinson";
        lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("cyber security");
        lecturerInterests.add("IOT");
        lecturerInterests.add("UI design");

        test.addLecture(lecturerName, lecturerInterests);


        String result = "";
        try {
            test.matching();
        }
        catch (Exception e)
        {
            //the algorithm should fail if there are more projects then lecturers
            result = e.getMessage();
        }


        String expected = "The number of projects must be equal to or less than the number of lecturers";

        assertEquals(expected, result);


    }

    @Test
    public void MoreLecturersThanProjects()
    {
        algorithm test = new algorithm(false, false);

        //project 1
        String projectName = "text to speech app";
        List<String> projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("natural language processing");
        projectTopics.add("app development");
        projectTopics.add("UI design");

        test.addProject(projectName, projectTopics);

        //project 2
        projectName = "home smart lock";
        projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("IOT");
        projectTopics.add("cyber security");
        projectTopics.add("app development");

        test.addProject(projectName, projectTopics);

        //lecturer 1
        String lecturerName = "Dr Brown";
        List<String> lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("natural language processing");
        lecturerInterests.add("app development");
        lecturerInterests.add("IOT");

        test.addLecture(lecturerName, lecturerInterests);

        //lecturer 2
        lecturerName = "Dr Robinson";
        lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("cyber security");
        lecturerInterests.add("IOT");
        lecturerInterests.add("UI design");

        test.addLecture(lecturerName, lecturerInterests);

        //lecturer 3
        lecturerName = "Dr Smith";
        lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("VR");
        lecturerInterests.add("games development");
        lecturerInterests.add("UI design");

        test.addLecture(lecturerName, lecturerInterests);

        test.matching();

        List<String> results = test.displayResults();

        String result = results.get(0);

        /*more projects may be added over time so meaning that not all lecturers
        will have a project but will have one as time continues this should
        not effect the algorithm*/
        String expected = "Project " + "text to speech app" + " is paired with "
                + " lecturer " + "Dr Brown"+ ".";

        assertEquals(expected, result);

    }

    @Test
    public void allDataTheSame()
    {
        /*
        this test consists of two lectures with the same interest
        and two projects with the same topic the only thing that
        should be different in the names
        both projects should be matched
         */

        algorithm test = new algorithm(false, false);

        //project 1
        String projectName = "text to speech app";
        List<String> projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("natural language processing");
        projectTopics.add("app development");
        projectTopics.add("UI design");

        test.addProject(projectName, projectTopics);

        //project 2
        projectName = "chat bot app";
        projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("natural language processing");
        projectTopics.add("app development");
        projectTopics.add("UI design");

        test.addProject(projectName, projectTopics);

        //lecturer 1
        String lecturerName = "Dr Brown";
        List<String> lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("natural language processing");
        lecturerInterests.add("app development");
        lecturerInterests.add("IOT");

        test.addLecture(lecturerName, lecturerInterests);

        //lecturer 2
        lecturerName = "Dr Smith";
        lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("natural language processing");
        lecturerInterests.add("app development");
        lecturerInterests.add("IOT");

        test.addLecture(lecturerName, lecturerInterests);

        test.matching();

        List<String> results = test.displayResults();

        String result = results.get(0);

        String expected = "Project " + "text to speech app" + " is paired with "
                + " lecturer " + "Dr Brown"+ ".";

        assertEquals(expected, result);

    }

    @Test
    public void addBadData()
    {
        //this is to ensure the project fails if missing is added

        String result = "";
        String expected = "";

        algorithm test = new algorithm(false, false);

        //project without name
        String projectName = "";
        List<String> projectTopics = new ArrayList<String>();
        //topics in order of importance
        projectTopics.add("natural language processing");
        projectTopics.add("app development");
        projectTopics.add("UI design");

        expected = "cannot added project without a name";

        try {
            test.addProject(projectName, projectTopics);
        }
        catch (Exception e)
        {
            result = e.getMessage();
        }

        assertEquals(expected, result);

        //project without topics
        projectName = "text to speech app";
        projectTopics = new ArrayList<String>();
        //topics in order of importance

        expected = "cannot added project without a list of topics";

        try {
            test.addProject(projectName, projectTopics);
        }
        catch (Exception e)
        {
            result = e.getMessage();
        }

        assertEquals(expected, result);

        //lecturer without name
        String lecturerName = "";
        List<String> lecturerInterests = new ArrayList<String>();
        //topics in order of importance
        lecturerInterests.add("natural language processing");
        lecturerInterests.add("app development");
        lecturerInterests.add("IOT");

        expected = "cannot added lecturer without a name";

        try {
            test.addLecture(lecturerName, lecturerInterests);
        }
        catch (Exception e)
        {
            result = e.getMessage();
        }

        assertEquals(expected, result);

        //lecturer without interests
        lecturerName = "Dr Brown";
        lecturerInterests = new ArrayList<String>();

        expected = "cannot added lecturer without a list of topics";

        try {
            test.addLecture(lecturerName, lecturerInterests);
        }
        catch (Exception e)
        {
            result = e.getMessage();
        }

        assertEquals(expected, result);


    }


}
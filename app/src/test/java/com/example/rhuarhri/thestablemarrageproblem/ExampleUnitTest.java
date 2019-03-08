package com.example.rhuarhri.thestablemarrageproblem;

import org.junit.Test;

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
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void randomInput()
    {
        //The algorithm should be able to successfully match this input

        /*
        algorithm test = new algorithm();

       list<project + lecture> result = test.pair(list<project> projects, list<lecturer> lecturers);

         */
    }
}
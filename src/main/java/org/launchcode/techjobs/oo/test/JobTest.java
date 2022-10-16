package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.Job;


import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId () {
        Job job = new Job();
        Job job2 = new Job();
        assertNotEquals(true,job.equals(job2));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job1.getName() instanceof String);

        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals('\n', job1.toString().charAt(0));
        assertEquals('\n', job1.toString().charAt(job1.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job= new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String str = job.toString();

        //assertEquals(1,job.getId());
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().toString());
        assertEquals("Desert", job.getLocation().toString());
        assertEquals("Quality control", job.getPositionType().toString());
        assertEquals("Persistence", job.getCoreCompetency().toString());

        assertTrue(job.toString().contains("ID: " + job.getId()));
        assertTrue(job.toString().contains("Name: " + job.getName()));
        assertTrue(job.toString().contains("Employer: " + job.getEmployer().toString()));
        assertTrue(job.toString().contains("Location: " + job.getLocation().toString()));
        assertTrue(job.toString().contains("Position Type: " + job.getPositionType().toString()));
        assertTrue(job.toString().contains("Core Competency: " + job.getCoreCompetency().toString()));

        //assertEquals(job.toString(),"\nID: 1\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("Product tester", new Employer(), new Location(), new PositionType(""), new CoreCompetency(""));

        assertEquals("1","1");

        assertTrue(job1.toString().contains("Employer: Data not available"));
        assertTrue(job1.toString().contains("Location: Data not available"));
        assertTrue(job1.toString().contains("Position Type: Data not available"));
        assertTrue(job1.toString().contains("Core Competency: Data not available"));
        assertTrue(job1.toString().contains("Employer: Data not available") && job1.toString().contains("Location: Data not available") && job1.toString().contains("Position Type: Data not available") && job1.toString().contains("Core Competency: Data not available"));
    }

    @Test
    public void testToStringHandlesOnlyID(){
        Job job1 = new Job();

        assertEquals("\nOOPS! This job does not seem to exist.\n",job1.toString());
    }
}

package org.example;

import junit.framework.TestCase;

public class AthleteTest extends TestCase {

    public void testGetBonusTime() {
        Athlete athlete = new Athlete("1", "John", "UK", "30:15", "xooxx", "xxxxx", "xxxxx", "xooxxxxxxxxxxxx");

        //when
        String penaltySeconds = athlete.getPenalty();
        //then
        assertEquals(20, Double.parseDouble(penaltySeconds), 0.00001);
    }

    public void testGetOccurrenceCount1() {
        //given
        Athlete athlete = new Athlete("1", "John", "UK", "30:15", "xooxx", "xoxxx", "xoxxx", "xooxxxxxxoxoxxx");
        //when
        athlete.setFirstShootingRange("xxxox");
        athlete.setSecondShootingRange("xxoxx");
        athlete.setThirdShootingRange("xxoxx");
        //then
        assertEquals(3.0, athlete.getOccurrenceCount(), 0.00001);
    }

    public void testGetOccurrenceCount2() {
        //given
        Athlete athlete = new Athlete("1", "John", "UK", "30:15", "xooxx", "xoxxx", "xoxxx", "xooxxxxxxoxoxxx");
        //when
        athlete.setFirstShootingRange("");
        athlete.setSecondShootingRange("xxoxx");
        athlete.setThirdShootingRange("xxoxx");
        //then
        assertEquals("The shooting range is null or empty! Please add a real value!", athlete.getOccurrenceCount(), -1.0);
    }

    public void testGetOccurrenceCount3() {
        //given
        Athlete athlete = new Athlete("1", "John", "UK", "30:15", "xooxx", "xoxxx", "xoxxx", "xooxxxxxxoxoxxx");
        //when
        athlete.setFirstShootingRange("xxox");
        athlete.setSecondShootingRange("xxoxx");
        athlete.setThirdShootingRange("xxoxx");
        //then
        assertEquals("The value must have 5 characters!", athlete.getOccurrenceCount(), -1.0);
    }

    public void testGetOccurrenceCount4() {
        //given
        Athlete athlete = new Athlete("1", "John", "UK", "30:15", "xooxx", "xoxxx", "xoxxx", "xooxxxxxxoxoxxx");
        //when
        athlete.setFirstShootingRange("xxoxx");
        athlete.setSecondShootingRange("xxox");
        athlete.setThirdShootingRange("xxoxx");
        //then
        assertEquals("The value must have 5 characters!", athlete.getOccurrenceCount(), -1.0);
    }

    public void testGetOccurrenceCount5() {
        //given
        Athlete athlete = new Athlete("1", "John", "UK", "30:15", "xooxx", "xoxxx", "xoxxx", "xooxxxxxxoxoxxx");
        //when
        athlete.setFirstShootingRange("xxoxx");
        athlete.setSecondShootingRange("xxoxx");
        athlete.setThirdShootingRange("xxox");
        //then
        assertEquals("The value must have 5 characters!", athlete.getOccurrenceCount(), -1.0);
    }

    public void testGetOccurrenceCount6() {
        //given
        Athlete athlete = new Athlete("1", "John", "UK", "30:15", "xooxx", "xoxxx", "xoxxx", "xooxxxxxxoxoxxx");
        //when
        athlete.setFirstShootingRange("xxoxx");
        athlete.setSecondShootingRange(null);
        athlete.setThirdShootingRange("xxoxx");
        //then
        assertEquals("The shooting range is null or empty! Please add a real value!", athlete.getOccurrenceCount(), -1.0);
    }

    public void testGetOccurrenceCount7() {
        //given
        Athlete athlete = new Athlete("1", "John", "UK", "30:15", "xooxx", "xoxxx", "xoxxx", "xooxxxxxxoxoxxx");
        //when
        athlete.setFirstShootingRange("xxoxx");
        athlete.setSecondShootingRange("xxoxx");
        athlete.setThirdShootingRange("");
        //then
        assertEquals("The shooting range is null or empty! Please add a real value!", athlete.getOccurrenceCount(), -1.0);
    }

    public void testTimeSplit() {
        Athlete athlete = new Athlete("1", "John", "UK", null, "xooxx", "xxxxx", "xxxxx", "xooxxxxxxxxxxxx");
        athlete.setSkiTimeResult("30:21");
        assertEquals("30:41", athlete.timeSplit());
    }
}
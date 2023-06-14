package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileHandlerTest {

    @Test
    public void testCreateAthleteFromStrings() {
        //given
        String[] input = {"1", "John Smith", "US", "29:15", "xxxxx", "xxxxx", "xxxxx" };
        //when
        Athlete athlete = new Athlete("1",
                "John Smith",
                "US",
                "29:15",
                "xxxxx",
                "xxxxx",
                "xxxxx",
                "xxxxxxxxxxxxxxx");

        Athlete athleteFromStrings = FileHandler.createAthleteFromStrings(input);
        //then
        assertEquals(athlete, athleteFromStrings);
    }
}
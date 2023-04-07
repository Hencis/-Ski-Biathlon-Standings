package org.example;
import junit.framework.TestCase;
import static org.example.FileOpener.createAthleteFromStrings;

public class FileOpenerTest extends TestCase {

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

        Athlete athleteFromStrings = createAthleteFromStrings(input);
        //then
        assertEquals(athlete, athleteFromStrings);
    }
}
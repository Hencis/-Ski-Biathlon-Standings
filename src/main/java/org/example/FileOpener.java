package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOpener {

    public static Athlete createAthleteFromStrings(String[] results) {
        String athleteNumber = results[0];
        String athleteName = results[1];
        String countryCode = results[2];
        String skiTimeResult = results[3];
        String firstShootingRange = results[4];
        String secondShootingRange = results[5];
        String thirdShootingRange = results[6];
        Athlete athlete =
                new Athlete(
                        athleteNumber,
                        athleteName,
                        countryCode,
                        skiTimeResult,
                        firstShootingRange,
                        secondShootingRange,
                        thirdShootingRange,
                        firstShootingRange + secondShootingRange + thirdShootingRange
                );
        return athlete;
    }

    public static List<Athlete> getAthletesFromInput(String inputFileName) {
        String line;
        String csvSplitBy = ",";
        List<Athlete> athletes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            while ((line = br.readLine()) != null) {
                String[] results = line.split(csvSplitBy);
                Athlete athlete = createAthleteFromStrings(results);
                athletes.add(athlete);
                athlete.getOccurrenceCount();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return athletes;
    }
}

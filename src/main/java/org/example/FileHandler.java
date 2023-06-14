package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static void writeAthletesToFile(List<Athlete> athletes) {
        String csvFile = "src/main/resources/winners.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
                StringBuilder sb = new StringBuilder();

            List<Athlete> winners = athletes.subList(0, 3);
            for (int i = 0; i < winners.size(); i++) {
                Athlete athlete = winners.get(i);
                Order place = null;
                switch (i) {
                    case 0:
                        place = Order.WINNER;
                        break;
                    case 1:
                        place = Order.RUNNER_UP;
                        break;
                    case 2:
                        place = Order.THIRD_PLACE;
                        break;
                }

                sb.append(place.toString());
                sb.append(" ");
                sb.append(athlete.getName());
                sb.append(" ");
                sb.append(athlete.timeSplit());
                sb.append(" ");
                sb.append("( ");
                sb.append(athlete.getSkiTimeResult());
                sb.append(" + ");
                sb.append(athlete.getPenalty());
                sb.append(" )");
                sb.append(" ");
                sb.append("\n");
            }
            writer.append(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Athlete> readAthletesFromFile(String inputFileName) {
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

    static Athlete createAthleteFromStrings(String[] results) {
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
}

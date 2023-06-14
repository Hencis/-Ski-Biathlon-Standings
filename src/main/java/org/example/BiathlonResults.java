package org.example;

import java.util.Comparator;
import java.util.List;

public class BiathlonResults {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/test.csv";
        List<Athlete> athletes = FileHandler.readAthletesFromFile(csvFile);
        athletes.sort(Comparator.comparing(Athlete::timeSplit));
        FileHandler.writeAthletesToFile(athletes);

    }
}
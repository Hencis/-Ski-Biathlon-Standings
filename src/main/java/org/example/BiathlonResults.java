package org.example;

import java.util.Comparator;
import java.util.List;

public class BiathlonResults {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/test.csv";
        List<Athlete> athletes = FileOpener.getAthletesFromInput(csvFile);
        athletes.sort(Comparator.comparing(Athlete::timeSplit));
        FileWriterr fileWriterr = new FileWriterr();
        fileWriterr.getAthletesInOutput(athletes);

    }
}
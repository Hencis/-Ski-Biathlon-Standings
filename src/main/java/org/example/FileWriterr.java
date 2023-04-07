package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterr {

    public void getAthletesInOutput(List<Athlete> athletes) {
        String csvFilee = "src/main/resources/winners.csv";
        try {
            FileWriter writer = new FileWriter(csvFilee);

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

                writer.append(place.toString());
                writer.append(" ");
                writer.append(athlete.getName());
                writer.append(" ");
                writer.append(athlete.timeSplit());
                writer.append(" ");
                writer.append("( ");
                writer.append(athlete.getSkiTimeResult());
                writer.append(" + ");
                writer.append(athlete.getPenalty());
                writer.append(" )");
                writer.append(" ");
                writer.append("\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package org.example;

import java.util.Objects;

import lombok.*;

//Here are the annotations + override in this class
@Getter
@Setter
@ToString
public class Athlete {

    String number;
    String name;
    String countryCode;
    String skiTimeResult;
    String firstShootingRange;
    String secondShootingRange;
    String thirdShootingRange;
    String last3Fields;

    public Athlete(String number, String name, String countryCode, String skiTimeResult, String firstShootingRange, String secondShootingRange, String thirdShootingRange, String last3Fields) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
        this.last3Fields = last3Fields;
    }

    /**
     * This method checks all the wrong ways the first, second and thirdShootingRange could be.
     * If the fields are incorrect, the program stops after a short message related to the problem.
     */
    public boolean checkShootingFields() {
        if ((firstShootingRange == null || firstShootingRange.isEmpty()) || (secondShootingRange == null || secondShootingRange.isEmpty()) || (thirdShootingRange == null || thirdShootingRange.isEmpty())) {
            System.out.println("The shooting range is null or empty! Please add a real value");
            return false;
        }
        if (firstShootingRange.length() != 5 || secondShootingRange.length() != 5 || thirdShootingRange.length() != 5) {
            System.out.println("The value must have 5 characters");
            return false;
        }
        for (int i = 0; i < firstShootingRange.length(); i++) {
            char c = firstShootingRange.charAt(i);
            if (c != 'x' && c != 'o') {
                System.out.println("The first string must contain only x or o");
                return false;
            }
        }
        for (int i = 0; i < secondShootingRange.length(); i++) {
            char c = secondShootingRange.charAt(i);
            if (c != 'x' && c != 'o') {
                System.out.println("The second string must contain only x or o");
                return false;
            }
        }
        for (int i = 0; i < thirdShootingRange.length(); i++) {
            char c = thirdShootingRange.charAt(i);
            if (c != 'x' && c != 'o') {
                System.out.println("The third string must contain only x or o");
                return false;
            }
        }
        return true;
    }

    /**
     * This method calculates all the occurrences of the letter 'o', so later we can work with that number.
     */

    public Double getOccurrenceCount() {
        if (checkShootingFields()) {
            String last3Fields = firstShootingRange + secondShootingRange + thirdShootingRange;
            Double count = 0.0;
            for (char c : last3Fields.toCharArray()) {
                if (c == 'o') {
                    count++;
                }
            }
            return count;
        }
        return -1.0;
    }

    /**
     * This method splits the skiTimeResult string input into 2 fields: minutes and seconds.
     * After that calculates the penalties with the help of the getOccurrenceCount() method.
     * The last step returns the updated version of the minutes and seconds.
     */
    public String timeSplit() {
        String[] resultParts = skiTimeResult.split(":");
        int minutes = Integer.parseInt(resultParts[0]);
        int seconds = Integer.parseInt(resultParts[1]);
        Double bonusTimeSeconds = getOccurrenceCount() * 10;
        seconds += bonusTimeSeconds;
        minutes += seconds / 60;
        seconds = seconds % 60;
        String result2 = String.format("%d:%02d", minutes, seconds);
        return result2;
    }

    /**
     * This method is helpful in the FileWriterr class, where the format of the output is
     * 30:27(initial minutes and seconds) + 30(penalties).
     * In our case, this method calculates the penalties.
     */
    public String getPenalty() {
        int penaltySeconds = 0;
        for (int i = 0; i < last3Fields.length(); i++) {
            if (last3Fields.charAt(i) == 'o') {
                penaltySeconds += 10;
            }
        }
        String result3 = String.format("%d", penaltySeconds);
        return result3;
    }

    /**
     * I needed to override the equals, because otherwise the testCreateAthleteFromStrings() method couldn't compare
     * the expected and the actual objects.
     */
    @Override
    public boolean equals(Object newAthlete) {
        if (this == newAthlete) return true;
        if (!(newAthlete instanceof Athlete)) return false;
        Athlete athlete = (Athlete) newAthlete;
        return Objects.equals(getNumber(), athlete.getNumber()) &&
                Objects.equals(getName(), athlete.getName()) &&
                Objects.equals(getCountryCode(), athlete.getCountryCode()) &&
                Objects.equals(getSkiTimeResult(), athlete.getSkiTimeResult()) &&
                Objects.equals(getFirstShootingRange(), athlete.getFirstShootingRange()) &&
                Objects.equals(getSecondShootingRange(), athlete.getSecondShootingRange()) &&
                Objects.equals(getThirdShootingRange(), athlete.getThirdShootingRange()) &&
                Objects.equals(getLast3Fields(), athlete.getLast3Fields());
    }

}

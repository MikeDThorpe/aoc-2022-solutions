package com.adventofcode.solutions;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    File input =
        new File(
            "/Users/michaelthorpe/Documents/Training/advent-of-code/2022-solutions/src/main/resources/input.txt");
    Scanner sc = new Scanner(input);

    var calorieCounter = new CalorieCounter(0);

    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      if (!Objects.equals(line, "")) {
        calorieCounter.incrementCalorieCount(Integer.parseInt(line));
      } else {
        calorieCounter.logCalorieCountAndReset();
      }
    }

    System.out.println(calorieCounter.calculateThreeHighestCalories());
  }
}

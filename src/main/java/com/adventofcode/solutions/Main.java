package com.adventofcode.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    File input =
        new File(
            "/Users/michaelthorpe/Documents/Training/advent-of-code/2022-solutions/src/main/resources/input.txt");
    Scanner sc = new Scanner(input);

    int res = 0;

    while (sc.hasNextLine()) {
      String line = sc.nextLine();
      String[] assignments = line.split(",");

      String[] assignment1Sections = assignments[0].split("-");
      String[] assignment2Sections = assignments[1].split("-");

      var assignment1 = new Assignment(
              Integer.parseInt(assignment1Sections[0]),
              Integer.parseInt(assignment1Sections[1])
      );

      var assignment2 = new Assignment(
              Integer.parseInt(assignment2Sections[0]),
              Integer.parseInt(assignment2Sections[1])
      );

      var assignmentComparator = new AssignmentComparator(
              assignment1,
              assignment2
      );

      // PART 1
      if (assignmentComparator.is1ContainedIn2() || assignmentComparator.is2ContainedIn1()) {
          res += 1;
      }

      // PART 2
      if(assignmentComparator.doesOverlap()) {
          res += 1;
      }

    }

    System.out.println(res);
  }

}

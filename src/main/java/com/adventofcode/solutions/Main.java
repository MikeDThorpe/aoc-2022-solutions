package com.adventofcode.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("/Users/michaelthorpe/Documents/Training/advent-of-code/2022-solutions/src/main/resources/input.txt");

        Scanner sc = new Scanner(input);

        Grid grid = new Grid(input);

        List<Integer> tailPositions = new ArrayList<>();

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineParts = line.split(" ");
            String direction = lineParts[0];
            Integer steps = Integer.parseInt(lineParts[1]);

            if (direction.equals("R")) grid.moveHeadRightOne();
            if (direction.equals("L")) grid.moveHeadLeftOne();
            if (direction.equals("U")) grid.moveHeadUpOne();
            if (direction.equals("D")) grid.moveHeadDownOne();

            System.out.println(grid.getHeadPosition());
            System.out.println(grid.getTailPosition());
            System.out.println("-----------------");
        }

    }

}

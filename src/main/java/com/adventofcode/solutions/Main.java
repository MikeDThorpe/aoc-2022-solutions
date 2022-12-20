package com.adventofcode.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("/Users/michaelthorpe/Documents/Training/advent-of-code/2022-solutions/src/main/resources/input.txt");
        Scanner sc = new Scanner(input);

        // noop one cycle to complete, no effect
        // addx takes two cycles

        List<String> commands = new ArrayList<>();

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            commands.add(line);
        }

        List<Integer> xValues = new ArrayList<>();
        // Part 1
        for(String command : commands) {
            if(command.equals("noop")) {
                if(xValues.isEmpty()) xValues.add(1);
                xValues.add(xValues.get(xValues.size() - 1));
                continue;
            }

            // handle addx string
            String[] stringParts = command.split(" ");
            Integer xValue = Integer.parseInt(stringParts[1]);
            if(xValues.isEmpty()) xValues.add(1); // populate first x value
            Integer lastXValue = xValues.get(xValues.size() - 1);
            xValues.add(lastXValue);
            xValues.add(lastXValue + xValue);
        }

        Integer cycle20 = xValues.get(19) * 20;
        Integer cycle60 = xValues.get(59) * 60;
        Integer cycle100 = xValues.get(99) * 100;
        Integer cycle140 = xValues.get(139) * 140;
        Integer cycle180 = xValues.get(179) * 180;
        Integer cycle220 = xValues.get(219) * 220;
//        System.out.println(cycle20 + cycle60 +  cycle100 + cycle140 + cycle180 + cycle220);



        // Part 2
        List<String> output = new ArrayList<>();
        int spritePosition = 1;
        int cycle = 0;

        for(String command : commands) {
            if(command.contains("addx")) {
                // two cycles
                for(int i = 0; i < 2; i++) {
                    cycle = getCycle(output, spritePosition, cycle);
                }

                int incrementValue = Integer.parseInt(command.split(" ")[1]);
                spritePosition += incrementValue;
            }

            if(command.contains("noop")) {
                cycle = getCycle(output, spritePosition, cycle);
            }

            System.out.println(spritePosition);
            System.out.println(cycle);
            System.out.println("----------------------");
        }

        // PRINT RESULT
        for(int i = 1 ; i <= output.size(); i++){
            System.out.print(output.get(i - 1));
            System.out.print(" ");
            if(i % 40 == 0) {
                System.out.println();
            }
        }
        // RFKZCPEF
    }

    private static int getCycle(List<String> output, int spritePosition, int cycle) {
        if(cycle >= 40) {
            cycle = 0;
        }
        cycle += 1;
        if(cycle == spritePosition || cycle == spritePosition + 1 || cycle == spritePosition + 2) {
            output.add("#");
        } else {
            output.add(".");
        }
        return cycle;
    }

}

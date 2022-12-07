package com.adventofcode.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File input =
                new File("/Users/michaelthorpe/Documents/Training/advent-of-code/2022-solutions/src/main/resources/input.txt");
        Scanner sc = new Scanner(input);

        var counter = new Counter();

        int lineCount = 0;
        String[] rucksacks = new String[3];

        while(sc.hasNextLine()) {
            rucksacks[lineCount] = sc.nextLine();
            lineCount += 1;

            if(lineCount == 3) {
                var groupRuckSack = new GroupRuckSack(rucksacks[0],rucksacks[1],rucksacks[2]);
                groupRuckSack.findDuplicate();
                counter.incrementScore(groupRuckSack.getDuplicateItem());
                lineCount = 0;
                rucksacks = new String[3];
            }
        }
        System.out.println(counter.getResult());
    }

}

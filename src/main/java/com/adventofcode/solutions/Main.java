package com.adventofcode.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("/Users/michaelthorpe/Documents/Training/advent-of-code/2022-solutions/src/main/resources/input.txt");

        Scanner sc = new Scanner(input);

        List<String> crate1 = new ArrayList<>(List.of("Q","M","G","C","L"));
        List<String> crate2 = new ArrayList<>(List.of("R","D","L","C","T","F","H","G"));
        List<String> crate3 = new ArrayList<>(List.of("V","J","F","N","M","T","W","R"));
        List<String> crate4 = new ArrayList<>(List.of("J","F","D","V","Q","P"));
        List<String> crate5 = new ArrayList<>(List.of("N","F","M","S","L","B","T"));
        List<String> crate6 = new ArrayList<>(List.of("R","N","V","H","C","D","P"));
        List<String> crate7 = new ArrayList<>(List.of("H","C","T"));
        List<String> crate8 = new ArrayList<>(List.of("G","S","J","V","Z","N","H","P"));
        List<String> crate9 = new ArrayList<>(List.of("Z","F","H","G"));

        List<List<String>> crates = new ArrayList<>(List.of(crate1, crate2, crate3, crate4, crate5, crate6, crate7, crate8, crate9));

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] numbers = line
                    .replace("move", "")
                    .replace("from", "")
                    .replace("to", "")
                    .trim()
                    .split("  "); // double space

            Integer amountToMove = Integer.parseInt(numbers[0]);
            List<String> stackToMoveFrom = crates.get(Integer.parseInt(numbers[1]) - 1);
            List<String> stackToMoveTo = crates.get(Integer.parseInt(numbers[2]) - 1);

            List<String> cratesToMove = new ArrayList<>();

            for(int i = 1; i <= amountToMove; i++) {
                String crateToMove = stackToMoveFrom.get(stackToMoveFrom.size() - 1);
                cratesToMove.add(0, crateToMove);
                stackToMoveFrom.remove(stackToMoveFrom.size() - 1);
            }

            for(int i = 0; i < cratesToMove.size(); i++) {
                stackToMoveTo.add(cratesToMove.get(i));
            }
        }

        String res = crates.stream()
                .map(crate -> crate.get(crate.size() -1))
                .collect(Collectors.joining());
        System.out.println(res);
    }
}

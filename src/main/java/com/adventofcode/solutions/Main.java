package com.adventofcode.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        String input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";

        List<String> inputQuart = new ArrayList();

        Integer indexTracker = 0;

        for(int i = 0; i < input.length(); i++) {

            String letter = String.valueOf(input.charAt(i));

            if(inputQuart.size() == 4) {
                System.out.println(inputQuart);

                // compare against
                List<String> comparatorList = new ArrayList<>();

                for(String s : inputQuart) {
                    if(comparatorList.contains(s)) {
                        break;
                    } else {
                        comparatorList.add(s);
                    }
                }

                // means all letters are different
                if(comparatorList.size() == 4) {
                    // calculate the index (+1) of the first letter in the 4
                    break;
                }
                inputQuart = new ArrayList<>();
                indexTracker += 5;
            }
            // add character to list
            inputQuart.add(letter);
        }

    System.out.println(indexTracker);
    }

}

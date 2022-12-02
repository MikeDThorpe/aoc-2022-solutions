package com.adventofcode.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File input =
                new File("/Users/michaelthorpe/Documents/Training/advent-of-code/2022-solutions/src/main/resources/input.txt");
        Scanner sc = new Scanner(input);

        // 0 - loss
        // 3 - draw
        // 6 - win

        // 1 - rock
        // 2 - paper
        // 3 - scissors

        // a, x - rock
        // b, y - paper
        // c, z - scissors

        // PART 2
        // X - lose
        // Y - draw
        // Z - win

        var scoreCounter = new ScoreCounter();

        while(sc.hasNextLine()) {
            String[] playerMoves = sc.nextLine().split("\\s+");
            String opponentMove = playerMoves[0];
//            String myMove = playerMoves[1];
//            scoreCounter.incrementScoreByMove(myMove);
//            scoreCounter.calculateResultAndIncrementScore(opponentMove, myMove);

            String endResult = playerMoves[1];
            scoreCounter.calculateResult(opponentMove, endResult);


        }
        System.out.println(scoreCounter.getScore());
    }

}

package com.adventofcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class ScoreCounter {

    private Integer score;

    public ScoreCounter() {
        this.score = 0;
    }

    public Integer getScore() {
        return score;
    }

    public void incrementScoreByMove(String move) {
        if(move.equals("X")) this.score = this.score + 1;
        if(move.equals("Y")) this.score = this.score + 2;
        if(move.equals("Z")) this.score = this.score + 3;
    }

    public void incrementScoreByResult(String res) {
        if (res.equals("win")) this.score = this.score + 6;
        if (res.equals("draw")) this.score = this.score + 3;
    }

    public void calculateResultAndIncrementScore(String oppMove, String myMove) {
        if(oppMove.equals("A")) {
            if(myMove.equals("X")) this.incrementScoreByResult("draw");
            if(myMove.equals("Y")) this.incrementScoreByResult("win");
         }
        if(oppMove.equals("B")) {
            if(myMove.equals("Y")) this.incrementScoreByResult("draw");
            if(myMove.equals("Z")) this.incrementScoreByResult("win");
        }
        if(oppMove.equals("C")) {
            if(myMove.equals("Z")) this.incrementScoreByResult("draw");
            if(myMove.equals("X")) this.incrementScoreByResult("win");
        }
    }

    public void calculateResultAgainstPaper(String endResult) {
        if(endResult.equals("X")) handleLoss("X");
        if(endResult.equals("Y")) handleDraw("Y");
        if(endResult.equals("Z")) handleWin("Z");
    }

    public void calculateResultAgainstScissors(String endResult) {
        if(endResult.equals("X")) handleLoss("Y");
        if(endResult.equals("Y")) handleDraw("Z");
        if(endResult.equals("Z")) handleWin("X");
    }

    public void calculateResultAgainstRock(String endResult) {
        if(endResult.equals("X")) handleLoss("Z");
        if(endResult.equals("Y")) handleDraw("X");
        if(endResult.equals("Z")) handleWin("Y");
    }

    public void calculateResult(String oppMove, String myMove) {
        if(oppMove.equals("A")) this.calculateResultAgainstRock(myMove);
        if(oppMove.equals("B")) this.calculateResultAgainstPaper(myMove);
        if(oppMove.equals("C")) this.calculateResultAgainstScissors(myMove);
    }

    public void handleWin(String myMove) {
        this.incrementScoreByMove(myMove);
        this.incrementScoreByResult("win");
    }

    public void handleLoss(String myMove) {
        this.incrementScoreByMove(myMove);
    }

    public void handleDraw(String myMove) {
        this.incrementScoreByMove(myMove);
        this.incrementScoreByResult("draw");
    }
}

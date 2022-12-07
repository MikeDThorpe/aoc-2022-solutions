package com.adventofcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Counter {

    private Integer result;
    private static final List alphabet = new ArrayList(
            List.of("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
    );

    public Counter() {
        this.result = 0;
    }

    public void incrementScore(char item) {
        Integer score = alphabet.indexOf(String.valueOf(item).toLowerCase()) + 1;
        if(Character.isUpperCase(item)) {
            score = score + 26;
        }
        Integer newResult = this.result + score;
        this.setResult(newResult);
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}

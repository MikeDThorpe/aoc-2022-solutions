package com.adventofcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCounter {
    private Integer calorieCount;
    private ArrayList<Integer> calorieCountList;

    public CalorieCounter(Integer calorieCount, ArrayList<Integer> calorieCountList) {
        this.calorieCount = calorieCount;
        this.calorieCountList = calorieCountList;
    }

    public void setCalorieCount(Integer calorieCount) {
        this.calorieCount = calorieCount;
    }

    public void addCalorie(Integer c) {
        calorieCountList.add(c);
    }

    public void incrementCalorieCount(Integer c) {
        setCalorieCount(calorieCount + c);
    }

    public Integer calculateThreeHighestCalories() {
        return calorieCountList.stream()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public void logCalorieCountAndReset() {
        this.addCalorie(calorieCount);
        this.setCalorieCount(0);
    }
}

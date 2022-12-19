package com.adventofcode.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;

public class Grid {
    private final Integer width;
    private final Integer height;
    private final Integer maxPositions;
    private Integer headPosition;
    private Integer tailPosition;
    List<Integer> tailPositions;

    public Grid(File f) throws FileNotFoundException {
        this.width = calculateGridWidth(f);
        this.height = calculateGridHeight(f);
        this.headPosition = 1;
        this.tailPosition = 1;
        this.maxPositions = height * width;
        this.tailPositions = new ArrayList<>();
    }

    public void moveTail() {

    }

    public boolean tailIsTouchingHead() {
        boolean isTouchingLeft = tailPosition + 1 == headPosition;
        boolean isTouchingRight = tailPosition - 1 == headPosition;
        boolean isTouchingUp = tailPosition + width == headPosition;
        boolean isTouchingBelow = tailPosition - width == headPosition;
        boolean isTouchingTopRight = tailPosition + (width + 1) == headPosition;
        boolean isTouchBottomRight = tailPosition - (width + 1) == headPosition;
        boolean isTouchingTopLeft = tailPosition + (width - 1) == headPosition;
        boolean isTouchBottomLeft = tailPosition - (width - 1) == headPosition;
        return isTouchingLeft || isTouchingRight || isTouchingUp || isTouchingBelow
                || isTouchingTopRight || isTouchBottomRight || isTouchBottomLeft || isTouchingTopLeft;
    }

    public boolean tailIsTwoStepsFromHead() {
        boolean tailIsTwoStepsLeft = tailPosition + 2 == headPosition;
        boolean tailIsTwoStepsRight = tailPosition - 2 == headPosition;
        boolean tailIsTwoStepsUp = tailPosition - (width * 2) == headPosition;
        boolean tailIsTwoStepsDown = tailPosition + (width * 2) == headPosition;
        return tailIsTwoStepsLeft || tailIsTwoStepsRight || tailIsTwoStepsUp || tailIsTwoStepsDown;
    }

    public void moveHeadRightOne() {
        setHeadPosition(headPosition + 1);
    }

    public void moveHeadLeftOne() {
        setHeadPosition(headPosition - 1);
    }

    public void moveHeadDownOne() {
        setHeadPosition(headPosition - width);
    }

    public void moveHeadUpOne() {
        setHeadPosition(headPosition + width);
    }

    public Integer getHeadPosition() {
        return headPosition;
    }

    public void setHeadPosition(Integer headPosition) {
        this.headPosition = headPosition;
    }

    public Integer getTailPosition() {
        return tailPosition;
    }

    public void setTailPosition(Integer tailPosition) {
        this.tailPosition = tailPosition;
    }

    public static Integer calculateGridWidth(File f) throws FileNotFoundException {
        List<Integer> gridWidths = new ArrayList<>();
        gridWidths.add(1);
        Integer widthTracker = 1;
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineParts = line.split(" ");
            String direction = lineParts[0];
            Integer steps = Integer.parseInt(lineParts[1]);
            if(direction.equals("R"))
                widthTracker = widthTracker + steps;
            if(direction.equals("L"))
                widthTracker -= steps;
            gridWidths.add(widthTracker);
        }
        return Collections.max(gridWidths);
    }

    public static Integer calculateGridHeight(File f) throws FileNotFoundException {
        List<Integer> gridWidths = new ArrayList<>();
        gridWidths.add(1);
        Integer widthTracker = 1;
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lineParts = line.split(" ");
            String direction = lineParts[0];
            Integer steps = Integer.parseInt(lineParts[1]);
            if(direction.equals("U"))
                widthTracker = widthTracker + steps;
            if(direction.equals("D"))
                widthTracker -= steps;
            gridWidths.add(widthTracker);
        }
        return Collections.max(gridWidths);
    }
}

package com.adventofcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Assignment {

    private Integer sectionFrom;
    private Integer sectionTo;
    private List<Integer> allsections;

    public Assignment(Integer sectionFrom, Integer sectionTo) {
        this.sectionFrom = sectionFrom;
        this.sectionTo = sectionTo;
        this.allsections = new ArrayList<>();

        for(int i = sectionFrom; i <= sectionTo; i++) allsections.add(i);
    }

    public List<Integer> getAllsections() {
        return allsections;
    }
}

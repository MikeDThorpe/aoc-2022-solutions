package com.adventofcode.solutions;

public class AssignmentComparator {

    private final Assignment assignment1;
    private final Assignment assignment2;

    public AssignmentComparator(Assignment assignment1, Assignment assignment2) {
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
    }

    public boolean is1ContainedIn2() {
        for(Integer v : this.assignment1.getAllsections()) {
          if (!assignment2.getAllsections().contains(v)) {
            return false;
          }
        }
        return true;
    }

    public boolean is2ContainedIn1() {
        for(Integer v : this.assignment2.getAllsections()) {
            if (!assignment1.getAllsections().contains(v)) {
                return false;
            }
        }
        return true;
    }

    public boolean doesOverlap() {
        for(Integer v : this.assignment1.getAllsections()) {
            if (assignment2.getAllsections().contains(v)) {
                return true;
            }
        }
        return false;
    }
}

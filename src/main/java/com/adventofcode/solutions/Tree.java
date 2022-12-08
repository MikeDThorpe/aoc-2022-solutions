package com.adventofcode.solutions;

import java.util.List;

public class Tree {

    private List<Integer> treesAbove;
    private List<Integer> treesBelow;
    private List<Integer> treesRight;
    private List<Integer> treesLeft;
    private Integer treeHeight;

    public Tree() {
    }

    public void setTreeHeight(Integer treeHeight) {
        this.treeHeight = treeHeight;
    }

    public void setTreesAbove(List<Integer> treesAbove) {
        this.treesAbove = treesAbove;
    }

    public void setTreesBelow(List<Integer> treesBelow) {
        this.treesBelow = treesBelow;
    }

    public void setTreesRight(List<Integer> treesRight) {
        this.treesRight = treesRight;
    }

    public void setTreesLeft(List<Integer> treesLeft) {
        this.treesLeft = treesLeft;
    }

    public boolean isVisibleFromAbove() {
        for(Integer h: treesAbove){
            if(h >= treeHeight)
                return false;
        }
        return true;
    }

    public boolean isVisibleFromBelow() {
        for(Integer h: treesBelow){
            if(h >= treeHeight)
                return false;
        }
        return true;
    }

    public boolean isVisibleFromRight() {
        for(Integer h: treesRight){
            if(h >= treeHeight)
                return false;
        }
        return true;

    }

    public boolean isVisibleFromLeft() {
        for(Integer h: treesLeft){
            if(h >= treeHeight)
                return false;
        }
        return true;
    }

    public Integer isBlockedAboveBy() {
        int treeCount = 0;

        for(Integer t : treesAbove) {
            treeCount += 1;
            if(t >= treeHeight) {
                break;
            }
        }

        return treeCount;
    }

    public Integer isBlockedBelowBy() {
        int treeCount = 0;

        for(Integer t : treesBelow) {
            treeCount += 1;
            if(t >= treeHeight) {
                break;
            }
        }

        return treeCount;
    }

    public Integer isBlockedRightBy() {
        int treeCount = 0;

        for(Integer t : treesRight) {
            treeCount += 1;
            if(t >= treeHeight) {
                break;
            }
        }

        return treeCount;
    }

    public Integer isBlockedLeftBy() {
        int treeCount = 0;

        for(Integer t : treesLeft) {
            treeCount += 1;
            if(t >= treeHeight) {
                break;
            }
        }

        return treeCount;
    }

    public Integer calcScenicScore() {
        return isBlockedAboveBy() * isBlockedLeftBy() * isBlockedBelowBy() * isBlockedRightBy();
    }

    public List<Integer> getTreesAbove() {
        return treesAbove;
    }

    public List<Integer> getTreesBelow() {
        return treesBelow;
    }

    public List<Integer> getTreesRight() {
        return treesRight;
    }

    public List<Integer> getTreesLeft() {
        return treesLeft;
    }

    public Integer getTreeHeight() {
        return treeHeight;
    }
}


package com.adventofcode.solutions;

import java.util.*;

public class Monkey {
    private Integer id;
    private Deque<Long> items;
    private Map<String, String> operation;
    private Integer divisibleBy;
    private Integer ifTrue;
    private Integer ifFalse;
    private Integer inspectionCount;

    public Monkey() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Deque<Long> getItems() {
        return items;
    }

    public void setItems(Deque<Long> items) {
        this.items = items;
    }

    public Map<String, String> getOperation() {
        return operation;
    }

    public void setOperation(Map<String, String> operation) {
        this.operation = operation;
    }

    public void setDivisibleBy(Integer divisibleBy) {
        this.divisibleBy = divisibleBy;
    }

    public Integer getIfTrue() {
        return ifTrue;
    }

    public void setIfTrue(Integer ifTrue) {
        this.ifTrue = ifTrue;
    }

    public Integer getIfFalse() {
        return ifFalse;
    }

    public void setIfFalse(Integer ifFalse) {
        this.ifFalse = ifFalse;
    }

    public Integer getInspectionCount() {
        return inspectionCount;
    }

    public void setInspectionCount(Integer inspectionCount) {
        this.inspectionCount = inspectionCount;
    }

    public Long performMultiplication(Long item) {
        String v = this.operation.get("right");
        if(v.equals("old")) {
            return item * item;
        }
        return item * Long.parseLong(v);
    }

    public Long performAddition(Long item) {
        String v = this.operation.get("right");
        if(v.equals("old")) {
            return item + item;
        }
        return item + Long.parseLong(v);
    }

    public boolean passesTest(Long i) {
        return i % this.divisibleBy == 0;
    }

    public Long inspectAndRecalculateItem(Long item) {
         this.setInspectionCount(this.inspectionCount + 1);
            if(this.getOperation().get("operation").equals("+")) {
                item = performAddition(item);
            } else {
                item = performMultiplication(item);
            }
            return item;
    }

    public void clearItems() {
        this.items.clear();
    }

    public void addItem(Long item) {
        this.items.addLast(item);
    }

}
package com.adventofcode.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Monkey {
    private Integer id;
    private List<Integer> items;
    private Map<String, String> operation; // new  = old + 3
    private Integer divisibleBy; // divisible by 17
    private Integer ifTrue;
    private Integer ifFalse;
    private Integer inspectionCount;

    public Monkey() {
    }

  public Monkey(
      Integer id,
      List<Integer> items,
      Map<String, String> operation,
      Integer divisibleBy,
      Integer ifTrue,
      Integer ifFalse) {
        this.id = id;
        this.items = items;
        this.operation = operation;
        this.divisibleBy = divisibleBy;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getItems() {
        return items;
    }

  public void setItems(List<Integer> items) {
        this.items = items;
    }

    public void addItem(Integer item) {
        this.items.add(item);
    }

    public void removeItem(int index) {
        System.out.println(items);
        this.items.remove(index);
    }

    public Map<String, String> getOperation() {
        return operation;
    }

    public void setOperation(Map<String, String> operation) {
        this.operation = operation;
    }

    public Integer getDivisibleBy() {
        return divisibleBy;
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

    public void incrementInspectionCount() {
        this.inspectionCount += 1;
    }

    public Integer performMultiplication(Integer item) {
        String v = this.operation.get("right");
        if(v.equals("old")) {
            return item * item;
        }
        return item * Integer.parseInt(v);
    }

    public Integer performAddition(Integer item) {
        String v = this.operation.get("right");
        if(v.equals("old")) {
            return item + item;
        }
        return item + Integer.parseInt(v);
    }

    public boolean passesTest(Integer i) {
        return i % this.divisibleBy == 0;
    }
}
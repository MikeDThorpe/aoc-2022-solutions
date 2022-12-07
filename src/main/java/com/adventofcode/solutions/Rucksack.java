package com.adventofcode.solutions;

public class Rucksack {

    private String allItems;
    private char[] firstCompartment;
    private char[] secondCompartment;
    private char duplicateItem;

    public Rucksack(String allItems) {
        this.allItems = allItems;
        final int mid = allItems.length() / 2;
        this.firstCompartment = allItems.substring(0, mid).toCharArray();
        this.secondCompartment = allItems.substring(mid).toCharArray();
    }

    public void findDuplicate() {

        int dupeCharI = -1;

        for(int i = 0; i < firstCompartment.length; i++) {
            for(int j = 0; j < secondCompartment.length; j++) {

                if (firstCompartment[i] == secondCompartment[j]) {
                    dupeCharI = i;
                    break;
                }

            }
        }
        this.setDuplicateItem(firstCompartment[dupeCharI]);
    }

    public char[] getFirstCompartment() {
        return firstCompartment;
    }

    public void setFirstCompartment(char[] firstCompartment) {
        this.firstCompartment = firstCompartment;
    }

    public char[] getSecondCompartment() {
        return secondCompartment;
    }

    public void setSecondCompartment(char[] secondCompartment) {
        this.secondCompartment = secondCompartment;
    }

    public char getDuplicateItem() {
        return duplicateItem;
    }

    public void setDuplicateItem(char duplicateItem) {
        this.duplicateItem = duplicateItem;
    }

    public String getAllItems() {
        return allItems;
    }

    public void setAllItems(String allItems) {
        this.allItems = allItems;
    }
}

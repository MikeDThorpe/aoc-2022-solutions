package com.adventofcode.solutions;

public class GroupRuckSack {

    private String elf1Rucksack;
    private String elf2Rucksack;
    private String elf3Rucksack;
    private char duplicateItem;

    public GroupRuckSack(String elf1Rucksack, String elf2Rucksack, String elf3Rucksack) {
        this.elf1Rucksack = elf1Rucksack;
        this.elf2Rucksack = elf2Rucksack;
        this.elf3Rucksack = elf3Rucksack;
    }

    public void findDuplicate() {
        int dupeCharIndex = -1;
        for(int i = 0; i < elf1Rucksack.length(); i++) {
            for(int j = 0; j < elf2Rucksack.length(); j++) {
                for(int k = 0; k < elf3Rucksack.length(); k++) {
                    if (elf1Rucksack.charAt(i) == elf2Rucksack.charAt(j) && elf1Rucksack.charAt(i) == elf3Rucksack.charAt(k)) {
                        dupeCharIndex = i;
                        break;
                    }
                }
            }
        }
        this.setDuplicateItem(elf1Rucksack.charAt(dupeCharIndex));
    }

    public char getDuplicateItem() {
        return duplicateItem;
    }

    public void setDuplicateItem(char duplicateItem) {
        this.duplicateItem = duplicateItem;
    }
}

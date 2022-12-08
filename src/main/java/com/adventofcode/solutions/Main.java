package com.adventofcode.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("/Users/michaelthorpe/Documents/Training/advent-of-code/2022-solutions/src/main/resources/input.txt");
        Scanner sc = new Scanner(input);

        Integer visibleTrees = 0;

        List<String> treeRows = new ArrayList<>();

        List<Integer> scenicScores = new ArrayList<>();

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            treeRows.add(line);
        }

        for(int i = 0; i < treeRows.size(); i++) {

            if(i == 0 || i == treeRows.size() - 1) {
                visibleTrees += treeRows.get(i).length();
                continue;
            }

            String treeRow = treeRows.get(i);
            for(int j = 0; j < treeRow.length(); j++) {

                if(j == 0 || j == treeRow.length() - 1) {
                    visibleTrees += 1;
                    continue;
                }

                var tree = new Tree();
                tree.setTreeHeight(Integer.parseInt(String.valueOf(treeRow.charAt(j))));

                List<Integer> treesLeft = new ArrayList<>();
                List<Integer> treesRight = new ArrayList<>();
                for(int k = 0 ; k < treeRow.length(); k++) {
                    final int tr = Integer.parseInt(String.valueOf(treeRow.charAt(k)));
                    if(k < j) treesLeft.add(0, tr);
                    else if (k > j) treesRight.add(tr);
                }

                List<Integer> treesAbove = new ArrayList<>();
                List<Integer> treesBelow = new ArrayList<>();
                for(int l = 0; l < treeRows.size(); l++) {
                    String treeRow2 = treeRows.get(l);
                    for(int m = 0; m < treeRow2.length(); m++) {
                        if(l == i && m == j) continue;
                        if(m == j) {
                            final int tr = Integer.parseInt(String.valueOf(treeRow2.charAt(m)));
                            if(l < i) treesAbove.add(0, tr);
                            else treesBelow.add(tr);
                        }
                    }
                }

                tree.setTreesAbove(treesAbove);
                tree.setTreesBelow(treesBelow);
                tree.setTreesLeft(treesLeft);
                tree.setTreesRight(treesRight);

                // PART 1
                if(tree.isVisibleFromAbove() || tree.isVisibleFromBelow() || tree.isVisibleFromLeft() || tree.isVisibleFromRight()) {
                    visibleTrees += 1;
                }
                // PART 2
                Integer scenicScore = tree.calcScenicScore();
                scenicScores.add(scenicScore);
            }
        }
            System.out.println(visibleTrees);
            System.out.println(Collections.max(scenicScores));
    }

}

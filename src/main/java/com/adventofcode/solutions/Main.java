package com.adventofcode.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("/Users/michaelthorpe/Documents/Training/advent-of-code/2022-solutions/src/main/resources/input.txt");
        Scanner sc = new Scanner(input);

        List<Monkey> monkeys = new ArrayList<>();

        List<String> monkeyAttributes = new ArrayList<>();

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            if(line.isEmpty()) continue;
            monkeyAttributes.add(line.trim());
            if(monkeyAttributes.size() == 6) {
                Monkey newMonkey = new Monkey();
                newMonkey.setId(monkeys.size());
                newMonkey.setItems(createItemList(monkeyAttributes.get(1)));
                newMonkey.setOperation(createOperation(monkeyAttributes.get(2)));
                newMonkey.setDivisibleBy(createTest(monkeyAttributes.get(3)));
                newMonkey.setIfTrue(calculateMonkeyToThrowToIfTrue(monkeyAttributes.get(4)));
                newMonkey.setIfFalse(calculateMonkeyToThrowToIfFalse(monkeyAttributes.get(5)));
                newMonkey.setInspectionCount(0);
                monkeys.add(newMonkey);
                monkeyAttributes.clear();
            }
        }

        for(int i = 0; i < 20; i++) {
            for(Monkey monkey : monkeys) {
                // loop over monkey items and perform operation
                ArrayList<Integer> reCalculatedItems = new ArrayList<>(monkey.getItems()
                        .stream()
                        .map(item -> {
                            return monkey.getOperation().get("operation") == "+" ?
                                    monkey.performAddition(item) : monkey.performMultiplication(item);
                        })
                        .map(item -> item / 3)
                        .toList());

                List<Integer> indexOfItemsToRemove = new ArrayList<>();

                // perform test
                for(int j = 0; j < reCalculatedItems.size(); j++) {
                    monkey.incrementInspectionCount();
                    Integer item = reCalculatedItems.get(j);
                    Monkey monkeyToThrowTo;
                    // throw to new monkey based on outcome of test
                    if(monkey.passesTest(item)) {
                        // throw to monkey if true
                        monkeyToThrowTo = monkeys.get(monkey.getIfTrue());
                    } else {
                        // throw to monkey if false
                        monkeyToThrowTo = monkeys.get(monkey.getIfFalse());
                    }
                    // add item to monkeyToThrowTo
                    monkeyToThrowTo.addItem(item);
                    // remove item from current monkey
                    indexOfItemsToRemove.add(j);
                }
                // remove items
                indexOfItemsToRemove.forEach(reCalculatedItems::remove);
                monkey.setItems(new ArrayList<>(reCalculatedItems));
            }
        }

        monkeys.forEach(monkey -> System.out.println(monkey.getInspectionCount()));
    }

    public static List<Integer> createItemList(String str) { // Starting items: 79, 98
        ArrayList<String> itemList = new ArrayList<>(Arrays.asList(
                str
                .replace("Starting items: ", "")
                .trim()
                .split(",")));
        return new ArrayList<>(itemList.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .toList());
    }

    public static Map<String, String> createOperation(String str) {
        String[] transformedString = str
                .replace("Operation: new = ", "")
                .trim()
                .split(" ");

        HashMap<String, String> operationMap = new HashMap<>();
        operationMap.put("left", transformedString[0].trim());
        operationMap.put("operation", transformedString[1].trim());
        operationMap.put("right", transformedString[2].trim());

        return operationMap;
    }

    public static Integer createTest(String str) {
        String transformedString = str
                .replace("Test: divisible by ", "");
        return Integer.parseInt(transformedString);
    }

    public static Integer calculateMonkeyToThrowToIfTrue(String str) {
        String transformedString = str
                .trim()
                .replace("If true: throw to monkey ", "");
        return Integer.parseInt(transformedString);
    }

    public static Integer calculateMonkeyToThrowToIfFalse(String str) {
        String transformedString = str
                .trim()
                .replace("If false: throw to monkey ", "");
        return Integer.parseInt(transformedString);
    }

}

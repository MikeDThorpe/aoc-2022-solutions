package com.adventofcode.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

        for(int i = 1; i <= 20; i++) {
            for(Monkey monkey : monkeys) {

                if (monkey.getItems().isEmpty()) continue;

                monkey.getItems()
                        .forEach(item -> {
                            item = monkey.inspectAndRecalculateItem(item);
                            Monkey monkeyToThrowTo = monkey.passesTest(item) ? monkeys.get(monkey.getIfTrue()) : monkeys.get(monkey.getIfFalse());
                            monkeyToThrowTo.addItem(item);
                        });
                monkey.clearItems();
            }
        }

        monkeys.forEach(
            monkey -> {
              System.out.println(
                  "Monkey "
                      + monkey.getId()
                      + " inspected items "
                      + monkey.getInspectionCount()
                      + " times");
              System.out.println(monkey.getItems());
            });
    }

    public static Deque<Long> createItemList(String str) { // Starting items: 79, 98
        ArrayList<String> itemList = new ArrayList<>(Arrays.asList(
                str
                .replace("Starting items: ", "")
                .trim()
                .split(",")));


        return new ArrayDeque<>(itemList.stream()
                .map(String::trim)
                .map(Long::parseLong)
                .toList()) {
        };
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

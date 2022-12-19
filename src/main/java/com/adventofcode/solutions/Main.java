package com.adventofcode.solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("/Users/michaelthorpe/Documents/Training/advent-of-code/2022-solutions/src/main/resources/input.txt");
        Scanner sc = new Scanner(input);

        List<List<String>> instructions = new ArrayList<>();
        List<String> instruction = new ArrayList<>();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();

            if(line.contains("$")) {
                if (!instruction.isEmpty())
                    instructions.add(instruction);
                instruction = new ArrayList<>();
            }


            instruction.add(line);
        }

        instructions.add(instruction);
        System.out.println(instructions);

        List<Directory> allDirectories = new ArrayList<>();
        List<com.adventofcode.solutions.File> allFiles = new ArrayList<>();

        Directory homeDirectory = new Directory();
        homeDirectory.setName("/");
        allDirectories.add(homeDirectory);

        Directory currentDirectory = homeDirectory;

        for (List<String> ins : instructions) {
            String command = ins.get(0);
          if (command.contains("cd")) {

            // get name from string
            String[] commandParts = command.split("\\s+");

            if (commandParts[2].equals("..")) {
                if(currentDirectory.getParentDirectory() != null) {
                    currentDirectory = currentDirectory.getParentDirectory();
                }
              continue;
            }

            Directory dir = doesDirectoryExist(commandParts[2], allDirectories);

            if (dir == null) {
              Directory newDirectory = new Directory();
              newDirectory.setName(commandParts[2]);
              newDirectory.setParentDirectory(currentDirectory);
              allDirectories.add(newDirectory);
              currentDirectory = newDirectory;
            } else {
              currentDirectory = dir;
            }
          } else {
            // handle list command - show contents of directory
            for (int i = 1; i < ins.size(); i++) {
              String content = ins.get(i);
              if (content.contains("dir")) {
                String[] dirParts = content.split("\\s+");

                Directory dir = doesDirectoryExist(dirParts[1], allDirectories);
                if (dir == null) {
                  Directory newDirectory = new Directory();
                  newDirectory.setName(dirParts[1]);
                  newDirectory.setParentDirectory(currentDirectory);
                  allDirectories.add(newDirectory);
                  currentDirectory.addDirectory(newDirectory);
                } else {
                  currentDirectory.addDirectory(dir);
                }
              } else {
                // add files in list
                String[] fileParts = content.split("\\s+");
                com.adventofcode.solutions.File file = checkFileExists(fileParts[0], allFiles);
                if (file == null) {
                  com.adventofcode.solutions.File newFile =
                      new com.adventofcode.solutions.File(fileParts[1], fileParts[0]);
                  allFiles.add(newFile);
                  currentDirectory.addFile(newFile);
                } else {
                  currentDirectory.addFile(file);
                }
              }
            }
          }
        }
        // calculate result
        allDirectories.forEach(dir -> System.out.println(dir.calculateDirectorySize()));
    }
    public static Directory doesDirectoryExist(String name, List<Directory> directories) {
        Optional<Directory> dir = directories.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst();
        return dir.orElse(null);
    }

    public static com.adventofcode.solutions.File checkFileExists(String name, List<com.adventofcode.solutions.File> files) {
        Optional<com.adventofcode.solutions.File> file = files.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst();
        return file.orElse(null);
    }
}

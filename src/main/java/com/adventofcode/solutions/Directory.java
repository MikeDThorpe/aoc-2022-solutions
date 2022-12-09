package com.adventofcode.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Directory {

    private String name;
    private List<File> files;
    private List<Directory> directories;
    private Directory parentDirectory;
    private Integer fileSize;

    public Directory() {
        this.files = new ArrayList<>();
        this.directories = new ArrayList<>();
        this.fileSize = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void addFile(File file) {
        this.files.add(file);
        this.fileSize = this.fileSize + Integer.parseInt(file.getFileSize());
    }

    public void addDirectory(Directory directory) {
        this.directories.add(directory);
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(List<Directory> directories) {
        this.directories = directories;
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(Directory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public void addFileSize(Integer fileSize) {
        this.fileSize += fileSize;
    }

    // TODO - calculate the total size of the directory including all files in nested directories
    public Integer calculateDirectorySize(List<Directory> dirs) {
        return flattenDependencies(dirs)
                .map(Directory::getFileSize)
                .reduce(0, Integer::sum);
    }

    public static Stream<Directory> flattenDependencies(List<Directory> dirs) {
        return dirs.stream().flatMap(dir -> {
            Stream<Directory> flattened = flattenDependencies(dir.getDirectories());
            return Stream.concat(Stream.of(dir), flattened);
        });
    }
}

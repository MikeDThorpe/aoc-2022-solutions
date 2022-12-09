package com.adventofcode.solutions;

public class File {

    private String name;
    private String fileSize;

    public File() {
    }

    public File(String name, String fileSize) {
        this.name = name;
        this.fileSize = fileSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}

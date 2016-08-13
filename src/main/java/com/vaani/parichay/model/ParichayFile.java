package com.vaani.parichay.model;

import lombok.ToString;

/**
 * Created by kchandra on 12/08/16.
 */
@ToString
public class ParichayFile {
    private String path;
    private ParichayFileStructure fileStructure;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ParichayFileStructure getFileStructure() {
        return fileStructure;
    }

    public void setFileStructure(ParichayFileStructure fileStructure) {
        this.fileStructure = fileStructure;
    }
}

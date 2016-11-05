package com.vaani.parichay.model;

import lombok.ToString;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Created by kchandra on 12/08/16.
 */
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

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

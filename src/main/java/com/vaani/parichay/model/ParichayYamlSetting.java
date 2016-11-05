package com.vaani.parichay.model;

import com.vaani.parichay.model.ParichayFile;
import lombok.ToString;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.List;

/**
 * Created by kchandra on 12/08/16.
 */
@ToString
public class ParichayYamlSetting {
    List<ParichayFile> files;

    public List<ParichayFile> getFiles() {
        return files;
    }

    public void setFiles(List<ParichayFile> files) {
        this.files = files;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

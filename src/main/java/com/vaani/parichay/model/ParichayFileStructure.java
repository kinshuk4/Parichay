package com.vaani.parichay.model;

import lombok.ToString;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Created by kchandra on 12/08/16.
 */

public class ParichayFileStructure {
    public ParichayFormatType formatType;
    public String delimiter;
    public String inputFormat;
    public String delimitedColumns;

    public String getDelimitedColumns() {
        return delimitedColumns;
    }

    public void setDelimitedColumns(String delimitedColumns) {
        this.delimitedColumns = delimitedColumns;
    }

    public ParichayFormatType getFileFormat() {
        return formatType;
    }

    public void setFileFormat(String fileFormat) {
        this.formatType = ParichayFormatType.valueOf(fileFormat);
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getInputFormat() {
        return inputFormat;
    }

    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

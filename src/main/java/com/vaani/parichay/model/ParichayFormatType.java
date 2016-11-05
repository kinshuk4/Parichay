package com.vaani.parichay.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Created by kchandra on 12/08/16.
 */
public enum ParichayFormatType {
    DELIMITED,JSON,XML;

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

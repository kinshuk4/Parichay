package com.vaani.parichay.parser.factory;

import com.vaani.parichay.model.ParichayFile;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Created by kchandra on 12/08/16.
 */
public class ParichayParserFactory<T> {
    private Class<T> type;
    public ParichayParserFactory(Class<T> type) {
        this.type = type;
    }

    public Class<T> getType() {
        return type;
    }


    public IParichayParser<T> getParser(ParichayFile file){
        switch (file.getFileStructure().getFileFormat()){
            case DELIMITED:
                return new ParichayCsvParser<T>(this.getType());
        }
        return null;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}

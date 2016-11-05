package com.vaani.parichay.parser.factory;

import com.vaani.parichay.model.ParichayFile;

import java.util.List;
import java.util.Map;

/**
 * Created by kchandra on 13/08/16.
 */
public interface IParichayParser<T> {
    List<T> parse(ParichayFile file);

    void parseToMap(ParichayFile file, Map<String, T> mapObj);
}

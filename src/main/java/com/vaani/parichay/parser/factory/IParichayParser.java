package com.vaani.parichay.parser.factory;

import com.vaani.parichay.model.ParichayFile;

import java.util.List;

/**
 * Created by kchandra on 13/08/16.
 */
public interface IParichayParser<T> {
    List<T> parse(ParichayFile file);
}

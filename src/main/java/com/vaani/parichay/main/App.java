package com.vaani.parichay.main;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vaani.parichay.demo.IsdnAgeCsv;
import com.vaani.parichay.parser.ImproperConfigException;
import com.vaani.parichay.parser.ParichayProcessor;

/**
 * Created by kchandra on 13/08/16.
 */
public class App {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, ImproperConfigException {
        ParichayProcessor<IsdnAgeCsv> ppi = new ParichayProcessor<IsdnAgeCsv>(IsdnAgeCsv.class);
        System.out.println(ppi);
        System.out.println(ppi.getType());
        ppi.init("/Users/kchandra/Lyf/Kode/SCM/Github/Zeotap/Parichay/src/main/resources/parichay_config.yaml");
    }
}

package com.vaani.parichay.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaani.parichay.model.ParichayYamlSetting;

import java.io.File;
import java.io.IOException;

/**
 * Created by kchandra on 12/08/16.
 */
public class ParichaySettingParser {


    public ParichayYamlSetting parse(String yamlSource){
        File file = new File(yamlSource);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        ParichayYamlSetting pys = null;
        try {
            pys = mapper.readValue(file, ParichayYamlSetting.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pys;
    }

    public static void main(String[] args) {
        String yamlFilePath="/Users/kchandra/Lyf/Kode/SCM/Github/Zeotap/Parichay/src/main/resources/parichay_config.yaml";
        ParichaySettingParser mapper = new ParichaySettingParser();

        ParichayYamlSetting pys = mapper.parse(yamlFilePath);
        System.out.println(pys);
    }
}

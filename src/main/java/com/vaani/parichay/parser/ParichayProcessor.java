package com.vaani.parichay.parser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vaani.parichay.model.ParichayFile;
import com.vaani.parichay.model.ParichayYamlSetting;
import com.vaani.parichay.parser.factory.IParichayParser;
import com.vaani.parichay.parser.factory.ParichayParserFactory;
import lombok.ToString;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by kchandra on 13/08/16.
 */
//@ToString
public class ParichayProcessor<T> {

    public Class<T> type;

    //TODO: Support multiple arrays instead of just one
    public ParichayProcessor(Class<T> type) {
        this.type = type;
    }

    public Class<T> getType() {
        return type;
    }

    //TODO: Support multiple file reads as map of string, and List<T> .. Current problem is T
    public List<T> init(String yamlSourceFilePath) throws ImproperConfigException {
        ParichayParserFactory<T> f = new ParichayParserFactory<T>(this.getType());
        ParichaySettingParser psp = new ParichaySettingParser();
        ParichayYamlSetting pys = psp.parse(yamlSourceFilePath);
//        System.out.println(pys);
        List<ParichayFile> pfList = pys.getFiles();
//        System.out.println(pfList);
        List<T> result = null;
        for (ParichayFile pf : pfList) {
            System.out.println(pf);
            IParichayParser<T> pcp = f.getParser(pf);

            result = pcp.parse(pf);
//            System.out.println(result);
        }
        return result;

    }
    
    public List<T> initN(String yamlSourceFilePath) throws ImproperConfigException {
        ParichayParserFactory<T> f = new ParichayParserFactory<T>(this.getType());
        ParichaySettingParser psp = new ParichaySettingParser();
        ParichayYamlSetting pys = psp.parse(yamlSourceFilePath);
//        System.out.println(pys);
        List<ParichayFile> pfList = pys.getFiles();
//        System.out.println(pfList);
        List<T> result = null;
        for (ParichayFile pf : pfList) {
//            System.out.println(pf);
            IParichayParser<T> pcp = f.getParser(pf);

            result = pcp.parse(pf);
//            System.out.println(result);
        }
        return result;

    }
    
    public void initToMap(String yamlSourceFilePath, Map<String, T> mapObj) throws ImproperConfigException{
        ParichayParserFactory<T> f = new ParichayParserFactory<T>(this.getType());
        ParichaySettingParser psp = new ParichaySettingParser();
        ParichayYamlSetting pys = psp.parse(yamlSourceFilePath);
//        System.out.println(pys);
        List<ParichayFile> pfList = pys.getFiles();
//        System.out.println(pfList);
//        List<T> result = null;
        for (ParichayFile pf : pfList) {
            System.out.println(pf);
            IParichayParser<T> pcp = f.getParser(pf);

            pcp.parseToMap(pf, mapObj);
            return;
//            System.out.println(result);
        }
//        return result;

    }

    public FileInputStream getFilePath(String yamlSourceFilePath) throws ImproperConfigException, FileNotFoundException{
        ParichayParserFactory<T> f = new ParichayParserFactory<T>(this.getType());
        ParichaySettingParser psp = new ParichaySettingParser();
        ParichayYamlSetting pys = psp.parse(yamlSourceFilePath);
//        System.out.println(pys);
        List<ParichayFile> pfList = pys.getFiles();
//        System.out.println(pfList);
        List<T> result = null;
        for (ParichayFile pf : pfList) {
            String filePath = pf.getPath();
            FileInputStream file = new FileInputStream(filePath);
            return file;
        }

        return null;
    }
    
    public String getFilePathStr(String yamlSourceFilePath) throws ImproperConfigException {
        ParichayParserFactory<T> f = new ParichayParserFactory<T>(this.getType());
        ParichaySettingParser psp = new ParichaySettingParser();
        ParichayYamlSetting pys = psp.parse(yamlSourceFilePath);
//        System.out.println(pys);
        List<ParichayFile> pfList = pys.getFiles();
//        System.out.println(pfList);
        List<T> result = null;
        for (ParichayFile pf : pfList) {
            String filePath = pf.getPath();
            return filePath;
        }

        return null;
    }
    
    
    public ParichayFile getParichayFile(String yamlSourceFilePath) throws ImproperConfigException{
        ParichayParserFactory<T> f = new ParichayParserFactory<T>(this.getType());
        ParichaySettingParser psp = new ParichaySettingParser();
        ParichayYamlSetting pys = psp.parse(yamlSourceFilePath);
//        System.out.println(pys);
        List<ParichayFile> pfList = pys.getFiles();
//        System.out.println(pfList);
        for (ParichayFile pf : pfList) {
        	return pf;
        }

        return null;
    }
    
    public String getParichayFileDelim(String yamlSourceFilePath) throws ImproperConfigException{
        ParichayParserFactory<T> f = new ParichayParserFactory<T>(this.getType());
        ParichaySettingParser psp = new ParichaySettingParser();
        ParichayYamlSetting pys = psp.parse(yamlSourceFilePath);
//        System.out.println(pys);
        List<ParichayFile> pfList = pys.getFiles();
//        System.out.println(pfList);
        for (ParichayFile pf : pfList) {
        	return pf.getFileStructure().getDelimiter();
        }

        return null;
    }
    
    public String[] getParichayColumns(String yamlSourceFilePath) throws  ImproperConfigException{
    	ParichayParserFactory<T> f = new ParichayParserFactory<T>(this.getType());
        ParichaySettingParser psp = new ParichaySettingParser();
        ParichayYamlSetting pys = psp.parse(yamlSourceFilePath);
//        System.out.println(pys);
        List<ParichayFile> pfList = pys.getFiles();
//        System.out.println(pfList);
        for (ParichayFile pf : pfList) {
        	return pf.getFileStructure().getDelimitedColumns().split(",");
        }

        return null;
    }
    
    
    
    public long lastModified(String yamlSourceFilePath) throws ImproperConfigException{
        ParichayParserFactory<T> f = new ParichayParserFactory<T>(this.getType());
        ParichaySettingParser psp = new ParichaySettingParser();
        ParichayYamlSetting pys = psp.parse(yamlSourceFilePath);
        
//        System.out.println(pys);
        List<ParichayFile> pfList = pys.getFiles();
//        System.out.println(pfList);
        List<T> result = null;
        for (ParichayFile pf : pfList) {
            String filePath = pf.getPath();
            File file = new File(filePath);
            return file.lastModified();
        }

        return -1;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}

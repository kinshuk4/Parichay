package com.vaani.parichay.parser;

import com.vaani.parichay.model.ParichayFile;
import com.vaani.parichay.model.ParichayYamlSetting;
import com.vaani.parichay.parser.factory.IParichayParser;
import com.vaani.parichay.parser.factory.ParichayParserFactory;
import lombok.ToString;

import java.util.List;

/**
 * Created by kchandra on 13/08/16.
 */
@ToString
public class ParichayProcessor<T> {

    public Class<T> type;

    public ParichayProcessor(Class<T> type) {
        this.type = type;
    }

    public Class<T> getType() {
        return type;
    }

    public void init(String yamlSourceFilePath) {
        ParichayParserFactory<T> f = new ParichayParserFactory<T>(this.getType());
        ParichaySettingParser psp = new ParichaySettingParser();
        ParichayYamlSetting pys = psp.parse(yamlSourceFilePath);
        System.out.println(pys);
        List<ParichayFile> pfList = pys.getFiles();
        System.out.println(pfList);
        for (ParichayFile pf : pfList) {
            System.out.println(pf);
            IParichayParser<T> pcp = f.getParser(pf);

            List<T> result = pcp.parse(pf);
            System.out.println(result);
        }

    }
}

package com.vaani.parichay.parser.factory;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.vaani.parichay.model.ParichayFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kchandra on 12/08/16.
 */
public class ParichayCsvParser<T> implements IParichayParser<T> {

    public Class<T> type;

    public ParichayCsvParser(Class<T> type) {
        this.type = type;
    }

    public Class<T> getType() {
        return type;
    }

    public List<T> parse(ParichayFile file) {
        CsvSchema.Builder builder = CsvSchema.builder();

        String delimitedColumns = file.getFileStructure().getDelimitedColumns();
        String[] delimitedColumnArr = delimitedColumns.split(",");
        for (String col : delimitedColumnArr) {
            builder = builder.addColumn(col);
        }

        CsvSchema schema = builder.build();
        schema = schema.withColumnSeparator(file.getFileStructure().getDelimiter().charAt(0));
        CsvMapper mapper = new CsvMapper();
        File file1 = new File(file.getPath());
        List<T> result = new ArrayList<T>();
        try {
//            result = mapper.readerWithTypedSchemaFor(this.getType()).with(schema).readValue(file1);
            MappingIterator<T> iter = mapper.readerWithTypedSchemaFor(this.getType()).with(schema).readValues(file1);
            while (iter.hasNext()) {
                T row = iter.next();
                result.add(row);
                // and voila, column values in an array. Works with Lists as well
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
        // Data binding syntax
//        String csv = mapper.writer(schema).writeValueAsString(value);
//        Pojo result = mapper.readerFor(Pojo.class).with(schema).read(csv);
    }

}

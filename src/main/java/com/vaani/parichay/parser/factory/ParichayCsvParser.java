package com.vaani.parichay.parser.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.vaani.parichay.model.ParichayFile;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        File fileObj = new File(file.getPath());
        List<T> result = new ArrayList<T>();
        try {
//            result = mapper.readerWithTypedSchemaFor(this.getType()).with(schema).readValue(file1);
            MappingIterator<T> iter = mapper.readerWithTypedSchemaFor(this.getType()).with(schema).readValues(fileObj);
            while (iter.hasNext()) {
                T row = iter.next();
                result.add(row);
                // and voila, column values in an array. Works with Lists as well
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }
    
    public static Object parseString(CsvSchema schema, CsvMapper mapper, String csvStr, Class type) throws JsonProcessingException, IOException{
    	MappingIterator iter = mapper.readerWithTypedSchemaFor(type).with(schema).readValue(csvStr);
    	return iter.next();
    }
    
    public List<T> dataParse(ParichayFile file, String data) {
        CsvSchema.Builder builder = CsvSchema.builder();

        String delimitedColumns = file.getFileStructure().getDelimitedColumns();
        String[] delimitedColumnArr = delimitedColumns.split(",");
        for (String col : delimitedColumnArr) {
            builder = builder.addColumn(col);
        }

        CsvSchema schema = builder.build();
        schema = schema.withColumnSeparator(file.getFileStructure().getDelimiter().charAt(0));
        CsvMapper mapper = new CsvMapper();
//        File fileObj = new File(file.getPath());
        List<T> result = new ArrayList<T>();
        try {
//            result = mapper.readerWithTypedSchemaFor(this.getType()).with(schema).readValue(file1);
            MappingIterator<T> iter = mapper.readerWithTypedSchemaFor(this.getType()).with(schema).readValue(data);
            while (iter.hasNext()) {
                T row = iter.next();
                result.add(row);
                // and voila, column values in an array. Works with Lists as well
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }
    
    public static <V> V get(Object object, String fieldName) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                return (V) field.get(object);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return null;
    }
    
    public void parseToMap(ParichayFile file, Map<String, T> mapObj) {
        CsvSchema.Builder builder = CsvSchema.builder();

        String delimitedColumns = file.getFileStructure().getDelimitedColumns();
        String[] delimitedColumnArr = delimitedColumns.split(",");
        for (String col : delimitedColumnArr) {
            builder = builder.addColumn(col);
        }

        CsvSchema schema = builder.build();
        schema = schema.withColumnSeparator(file.getFileStructure().getDelimiter().charAt(0));
        CsvMapper mapper = new CsvMapper();
        File fileObj = new File(file.getPath());
//        List<T> result = new ArrayList<T>();
        try {
//            result = mapper.readerWithTypedSchemaFor(this.getType()).with(schema).readValue(file1);
            MappingIterator<T> iter = mapper.readerWithTypedSchemaFor(this.getType()).with(schema).readValues(fileObj);
            while (iter.hasNext()) {
                T row = iter.next();
                String isdn = ParichayCsvParser.get(row, "isdn");
                if (isdn!=null){
                	System.out.println(isdn);
                	mapObj.put(isdn, row);
                }
                
                // and voila, column values in an array. Works with Lists as well
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return result;

    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}

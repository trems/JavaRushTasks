package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
        System.out.println(s);
        System.out.println(f);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.USE_ANNOTATIONS);

        return mapper.convertValue(one, resultClassObject);

//        String json = writer.toString();
//        json = json.replace(one.getClass().getSimpleName().toLowerCase(), resultClassObject.getSimpleName().toLowerCase());
//
//        return mapper.readValue(json, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    @JsonIgnoreProperties("className")
    public static class First {
        public int i = 1;
        public String name = "name1";

        @Override
        public String toString() {
            return "First{" +
                    "i=" + i +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int i = 2;
        public String name = "name2";

        @Override
        public String toString() {
            return "Second{" +
                    "i=" + i +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}

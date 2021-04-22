package com.allaber.jackson;

import com.allaber.models.Predicate;
import com.allaber.models.PredicateGroup;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Converter {

    private final static String baseFile = "location.json";

    public static String toJSON(PredicateGroup predicateGroup) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), predicateGroup);
        System.out.println("json created!");
        return mapper.writeValueAsString(predicateGroup);
    }

    public static String toJSON(Predicate predicate) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), predicate);
        System.out.println("json created!");
        return mapper.writeValueAsString(predicate);
    }
    public static PredicateGroup toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), PredicateGroup.class);
    }

}
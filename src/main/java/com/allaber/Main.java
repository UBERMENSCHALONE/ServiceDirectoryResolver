package com.allaber;

import com.allaber.jackson.Converter;
import com.allaber.models.Predicate;
import com.allaber.models.PredicateGroup;
import com.allaber.resolvers.PredicateGroupResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.allaber.enums.LogicalType.ALL;
import static com.allaber.enums.LogicalType.ANY;
import static com.allaber.enums.OperationType.CONTAINS;

public class Main {

    public static void main(String[] args) {

        Predicate predicate = new Predicate(1, "Город", CONTAINS, "cityId", "1");
        Predicate predicateStreet = new Predicate(1, "Улица", CONTAINS, "streetId", "1");

        List<Predicate> predicateList = new LinkedList<>();
        predicateList.add(predicate);
        predicateList.add(predicateStreet);


        List<PredicateGroup> list = new LinkedList<>();
        List<PredicateGroup> list2 = new LinkedList<>();
        PredicateGroup predicateGroup2 = new PredicateGroup(2, "predicates", ANY, predicateList, list2);
        list.add(predicateGroup2);


        PredicateGroup predicateGroup = new PredicateGroup(1, "predicates", ALL, predicateList, list);

        Map<String, String> params = new HashMap<>();
        params.put("cityId", "1");
        params.put("streetId", "1");


        // в JSON и обратно
        String s2 = toJson(predicateGroup);
        PredicateGroup predicateGroup1 = toJavaObject(s2);

        PredicateGroupResolver predicateGroupResolver = new PredicateGroupResolver();
        if (predicateGroupResolver.resolve(predicateGroup, params)) {
            System.out.println("Уфа");
        } else {
            System.out.println("Локация не определена");
        }
    }

    private static String toJson(PredicateGroup predicateGroup) {
        String s = null;
        Converter converter = new Converter();
        try {
            s = converter.toJSON(predicateGroup);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    private static PredicateGroup toJavaObject(String s) {
        Converter converter = new Converter();
        PredicateGroup predicateGroup = null;
        try {
            predicateGroup = converter.toJavaObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return predicateGroup;
    }
}

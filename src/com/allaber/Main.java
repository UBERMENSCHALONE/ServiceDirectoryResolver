package com.allaber;

import com.allaber.enums.LogicalType;
import com.allaber.models.Predicate;
import com.allaber.models.PredicateGroup;
import com.allaber.resolvers.PredicateGroupResolver;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.allaber.enums.OperationType.CONTAINS;
import static com.allaber.enums.OperationType.EQUALS;

public class Main {

    public static void main(String[] args) {

        Predicate predicate = new Predicate(1, "Город", CONTAINS, "cityId", "1");
        Predicate predicateStreet = new Predicate(1, "Улица", CONTAINS, "streetId", "2");
        List<Predicate> predicateList = new LinkedList<>();
        predicateList.add(predicate);
        predicateList.add(predicateStreet);
        List<PredicateGroup> list = new LinkedList<>();
        PredicateGroup predicateGroup = new PredicateGroup(1, "predicates", EQUALS, LogicalType.ALL, predicateList, list);

        Map<String, String> params = new HashMap<>();
        params.put("cityId", "1");
        params.put("streetId", "2");


        PredicateGroupResolver predicateGroupResolver = new PredicateGroupResolver();
        if (predicateGroupResolver.resolve(predicateGroup, params)) {
            System.out.println("Уфа");
        } else {
            System.out.println("Локация не определена");
        }
    }
}

package com.allaber;

import com.allaber.enums.LogicalType;
import com.allaber.models.Predicate;
import com.allaber.models.PredicateGroup;
import com.allaber.resolvers.PredicateGroupResolver;

import java.util.LinkedList;
import java.util.List;

import static com.allaber.enums.OperationType.CONTAINS;
import static com.allaber.enums.OperationType.EQUALS;

public class Main {

    public static void main(String[] args) {

        Predicate predicate = new Predicate(1, "Город", CONTAINS, "cityId", "1");
        List<Predicate> predicateList = new LinkedList<>();
        predicateList.add(predicate);
        List<PredicateGroup> list = new LinkedList<>();
        PredicateGroup predicateGroup = new PredicateGroup(1, "predicates", EQUALS, LogicalType.ALL, predicateList, list);

        PredicateGroupResolver predicateGroupResolver = new PredicateGroupResolver();
        if (predicateGroupResolver.resolve(predicateGroup, ERP.getHouse())) {
            System.out.println("Уфа");
        } else {
            System.out.println("Локация не определена");
        }


//        PredicateResolver  predicateResolver = new PredicateResolver();
//        if (predicateResolver.resolve(predicate)) {
//            System.out.println("Уфа");
//        } else {
//            System.out.println("Локация не определена");
//        }
    }
}

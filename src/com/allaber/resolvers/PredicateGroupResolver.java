package com.allaber.resolvers;

import com.allaber.enums.LogicalType;
import com.allaber.factory.OperationFactory;
import com.allaber.models.House;
import com.allaber.models.Predicate;
import com.allaber.models.PredicateGroup;

import java.util.HashMap;
import java.util.Map;

public class PredicateGroupResolver {
    public static boolean resolve(PredicateGroup predicateGroup, Map<String, String> map) {

        if(predicateGroup.getLogicalType() == LogicalType.ALL){
            return (getPredicateGroupAll(predicateGroup, map)) && (getPredicateAll(predicateGroup, map));
        } else {
            return (getPredicateGroupAny(predicateGroup, map)) && (getPredicateAny(predicateGroup, map));
        }
    }

    private static boolean getPredicateGroupAll(PredicateGroup predicateGroup, Map<String, String> map){
        return predicateGroup.getPredicateGroups().stream().allMatch(s ->
                PredicateGroupResolver.resolve(s, map));
    }

    private static boolean getPredicateAll(PredicateGroup predicateGroup, Map<String, String> map){
        return predicateGroup.getPredicates().stream().allMatch(s ->
                OperationFactory.getInstance(s.getTypeOperation()).test(map.get(s.getActualKey()), s.getArgument()));
    }

    private static boolean getPredicateGroupAny(PredicateGroup predicateGroup, Map<String, String> map){
        return predicateGroup.getPredicateGroups().stream().anyMatch(s ->
                PredicateGroupResolver.resolve(s, map));
    }

    private static boolean getPredicateAny(PredicateGroup predicateGroup, Map<String, String> map){
        return predicateGroup.getPredicates().stream().anyMatch(s ->
                OperationFactory.getInstance(s.getTypeOperation()).test(map.get(s.getActualKey()), s.getArgument()));
    }
}
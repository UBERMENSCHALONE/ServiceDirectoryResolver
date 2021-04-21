package com.allaber.resolvers;

import com.allaber.enums.LogicalType;
import com.allaber.factory.OperationFactory;
import com.allaber.models.House;
import com.allaber.models.Predicate;
import com.allaber.models.PredicateGroup;

public class PredicateGroupResolver {
    public boolean resolve(PredicateGroup predicateGroup, House house) {
        if (predicateGroup.getLogicalType() == LogicalType.ALL) {
            for (Predicate predicate : predicateGroup.getPredicates()) {
                if ( !(OperationFactory.getInstance(predicate.getTypeOperation()).test(house.getParams().get(predicate.getActualKey()), predicate.getArgument()))) {
                return false;
                }
            }
            return true;
        }

        if (predicateGroup.getLogicalType() == LogicalType.ANY) {
            for (Predicate predicate : predicateGroup.getPredicates()) {
                if ( !(OperationFactory.getInstance(predicate.getTypeOperation()).test(house.getParams().get(predicate.getActualKey()), predicate.getArgument()))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
package com.allaber.resolvers;

import com.allaber.factory.OperationFactory;
import com.allaber.models.Predicate;

public class PredicateResolver {
    public boolean resolve(Predicate predicate) {
        return OperationFactory.getInstance(predicate.getOperationType()).test(predicate.getActualKey(), predicate.getArgument());
    }
}

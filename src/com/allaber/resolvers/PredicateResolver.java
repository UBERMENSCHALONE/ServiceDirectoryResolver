package com.allaber.resolvers;

import com.allaber.factory.OperationFactory;
import com.allaber.models.Predicate;

public class PredicateResolver {
    public boolean resolve(Predicate predicate){
                if(OperationFactory.getInstance(predicate.getTypeOperation()).test(predicate.getActualKey(), predicate.getArgument())){
                    return true;
                }
                return false;
    }
}

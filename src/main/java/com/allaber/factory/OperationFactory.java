package com.allaber.factory;

import com.allaber.enums.OperationType;

public class OperationFactory {
    public static Operation getInstance(OperationType operationType) {
        Operation operation = null;

        switch (operationType) {
            case EQUALS:
                return new Equals();
            case CONTAINS:
                return new Contains();
        }

        return operation;
    }
}
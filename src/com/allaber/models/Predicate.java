package com.allaber.models;

import com.allaber.enums.OperationType;

public class Predicate {
    private int id;
    private String name;
    private OperationType operationType;
    private String actualKey;
    private String argument;

    public Predicate() {
    }

    public Predicate(int id, String name, OperationType operationType, String actualKey, String argument) {
        this.id = id;
        this.name = name;
        this.operationType = operationType;
        this.actualKey = actualKey;
        this.argument = argument;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OperationType getTypeOperation() {
        return operationType;
    }

    public void setTypeOperation(OperationType operationType) {
        this.operationType = operationType;
    }

    public String getActualKey() {
        return actualKey;
    }

    public void setActualKey(String actualKey) {
        this.actualKey = actualKey;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}

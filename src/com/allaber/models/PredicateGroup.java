package com.allaber.models;

import com.allaber.enums.LogicalType;
import com.allaber.enums.OperationType;

import java.util.List;

public class PredicateGroup {
    private int id;
    private String name;
    private OperationType operationType;
    private LogicalType logicalType;
    private List<Predicate> predicates;
    private List<PredicateGroup> predicateGroups;

    public PredicateGroup() {
    }

    public PredicateGroup(int id, String name, OperationType operationType, LogicalType logicalType, List<Predicate> predicates, List<PredicateGroup> predicateGroups) {
        this.id = id;
        this.name = name;
        this.operationType = operationType;
        this.logicalType = logicalType;
        this.predicates = predicates;
        this.predicateGroups = predicateGroups;
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

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public LogicalType getLogicalType() {
        return logicalType;
    }

    public void setLogicalType(LogicalType logicalType) {
        this.logicalType = logicalType;
    }

    public List<Predicate> getPredicates() {
        return predicates;
    }

    public void setPredicates(List<Predicate> predicates) {
        this.predicates = predicates;
    }

    public List<PredicateGroup> getPredicateGroups() {
        return predicateGroups;
    }

    public void setPredicateGroups(List<PredicateGroup> predicateGroups) {
        this.predicateGroups = predicateGroups;
    }
}

package com.allaber.factory;

public class Contains implements Operation {

    @Override
    public boolean test(String first, String second) {
        return first.contains(second);
    }
}
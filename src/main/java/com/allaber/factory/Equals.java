package com.allaber.factory;

public class Equals implements Operation {

    @Override
    public boolean test(String first, String second) {
        return first.equals(second);
    }
}
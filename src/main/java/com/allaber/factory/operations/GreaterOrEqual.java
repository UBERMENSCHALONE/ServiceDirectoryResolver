package com.allaber.factory.operations;

import com.allaber.factory.Operation;

public class GreaterOrEqual implements Operation {

    @Override
    public boolean test(String first, String second) {
        return Integer.parseInt(first) <= Integer.parseInt(second);
    }
}
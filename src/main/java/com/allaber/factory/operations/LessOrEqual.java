package com.allaber.factory.operations;

import com.allaber.factory.Operation;

public class LessOrEqual implements Operation {

    @Override
    public boolean test(String first, String second) {
        return Integer.parseInt(first) >= Integer.parseInt(second);
    }
}
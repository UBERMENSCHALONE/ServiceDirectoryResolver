package com.allaber.factory.operations;

import com.allaber.factory.Operation;

public class DoesNotContain implements Operation {

    @Override
    public boolean test(String first, String second) {
        return !first.contains(second);
    }
}
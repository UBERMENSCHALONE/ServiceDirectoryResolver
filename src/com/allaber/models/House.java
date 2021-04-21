package com.allaber.models;

import java.util.HashMap;

public class House {
    HashMap<String, String> params;

    public House(HashMap<String, String> params) {
        this.params = params;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }
}

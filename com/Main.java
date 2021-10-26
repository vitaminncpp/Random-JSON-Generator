package com;

import com.json.JSON;
import com.json.JSONKey;
import com.json.JSONStr;

public class Main {
    public static void main(String[] args) {
JSONKey key=JSONStr.generate(25);

        System.out.println(JSON.generate(25, 25, 25, 25));
    }
}

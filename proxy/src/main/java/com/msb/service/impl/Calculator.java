package com.msb.service.impl;

import com.msb.service.ICalculator;

public class Calculator implements ICalculator {
    public Integer add(Integer a, Integer b) {
        return a+b;
    }

    public Integer div(Integer a, Integer b) {
        return a/b;
    }
}

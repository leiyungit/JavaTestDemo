package com.msb.service.impl;

import com.msb.service.ICalculator;

public class Calculator implements ICalculator {

    @Override
    public Integer add(Integer a, Integer b) {
        return a+b;
    }

    @Override
    public Integer div(Integer a, Integer b) {
        return a/b;
    }
}

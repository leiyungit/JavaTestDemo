package com.msb.proxy;

import com.msb.service.ICalculator;
import com.msb.service.impl.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorProxy {

    public static ICalculator getCalculator(final ICalculator calculator){
        ClassLoader loader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName()+" 方法执行前....参数："+ Arrays.asList(args));
                Object invoke = method.invoke(calculator, args);
                System.out.println(method.getName()+" 方法执行后....结果：" + invoke);
                return invoke;
            }
        };
        Object o = Proxy.newProxyInstance(loader, interfaces, handler);
        return (ICalculator)o;
    }
}

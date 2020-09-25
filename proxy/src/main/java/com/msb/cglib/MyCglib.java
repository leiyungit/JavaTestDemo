package com.msb.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglib implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 代理方法执行之前");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib 代理方法执行之后");
        return o1;
    }
}

package com.msb.util;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtil {
    public static void start(Method method, Object ... args){
        System.out.println(method.getName()+" 方法执行前....参数："+ Arrays.asList(args));
    }

    public static void stop(Method method, Object result){
        System.out.println(method.getName()+" 方法执行后....结果：" + result);
    }

    public static void Exception(Method method,Exception e){
        System.out.println(method.getName()+" 方法执行异常：" + e.toString());
    }

    public static void end(Method method){
        System.out.println(method.getName()+" 方法执行完...over：");
    }
}

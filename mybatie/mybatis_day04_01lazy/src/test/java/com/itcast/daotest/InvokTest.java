package com.itcast.daotest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokTest {
    static class Animal {
        public void print() {
            System.out.println("Animal.print()");
        }
    }

    static class Cat extends Animal {

        @Override
        public void print() {
            System.out.println("Cat.print()");
        }
    }
    public static void main(String[] args) throws Exception{
        Method animalMethod = Animal.class.getDeclaredMethod("print");
        Method catMethod = Cat.class.getDeclaredMethod("print");

        Animal animal = new Animal();
        Cat cat = new Cat();
        animalMethod.invoke(cat); //相当于 cat调用父类的print方法
        animalMethod.invoke(animal);//相当于 animal.print();

        catMethod.invoke(cat); //相当于 cat.print();
        catMethod.invoke(animal);
    }
}

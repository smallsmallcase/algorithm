package com.huj;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * package: com.huj
 * date: 2018/9/28 11:42
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class test {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat();
    }

}


class Animal{
    public void eat() {
        System.out.println("动物在吃饭");
    }

    public Integer age;


}

class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗在吃饭");
    }

    public void run() {
        System.out.println("狗在跑，跑的很快");

    }
}

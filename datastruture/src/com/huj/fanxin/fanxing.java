package com.huj.fanxin;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.huj
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class fanxing {
    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList<>();
        Canvas c = new Canvas();
        c.drawAll(circleList);

    }
}


class Circle extends Shape {

    @Override
    public void draw(Canvas c) {
        System.out.println("在画布" +c+ "上画了一个圆");
    }
}

class Rectangle extends Shape{

    @Override
    public void draw(Canvas c) {
        System.out.println("在画布" + c + "画了一个矩形");
    }
}


abstract class Shape{
    public abstract void draw(Canvas c);

}


class Canvas{
    public void drawAll(List<? extends Shape> shapes) {
        for (Shape s : shapes) {
            s.draw(this);
        }
    }
}

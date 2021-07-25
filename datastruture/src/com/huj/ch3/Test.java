package com.huj.ch3;

/**
 * package: com.huj.ch3
 * date: 2018/10/8 21:40
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class Test {
    private int theSize;
    public void func2() {
        new SubTest().func();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.theSize = 2;
        test.func2();

    }


    class SubTest {
        public void func() {
            System.out.println(theSize);

        }
    }
}


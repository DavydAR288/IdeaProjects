//Необходимо сравнить скорость работы 2 алгоритмов вычисления чисел Фибоначчи и определить, какой из них работает быстрее.

package org.example;

import java.util.Date;

public class Ex6 {

    public static void main(String[] args) {
        Date start1=new Date();
        System.out.println(fib1(30));
        Date stop1=new Date();

        Date start2=new Date();
        fib2(30);
        Date stop2=new Date();

        System.out.println(stop1.getTime() - start1.getTime());
        System.out.println(stop2.getTime() - start2.getTime());

    }

    public static int fib1(int n) {

        if (n <= 2) {

            return 1;
        } else {
            return fib1(n - 1) + fib1(n - 2);
        }
    }

    public static void fib2(int num) {
        int first = 1;
        int second = 1;

        for (int i = 2; i < num; i++) {

            int third = first + second;
            first = second;
            second = third;

        }
        System.out.println(second);
    }
}


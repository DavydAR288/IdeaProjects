//Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
//        Считаем, что 1 и 2 значения последовательности равны 1.
//        Искать будем по формуле On=On-1+On-2 что предполагает использовать рекурсивного алгоритма.   


package org.example;

public class Ex4 {

    public static void main(String[] args) {
        System.out.println("fib(10) = " + fib(10));

    }

    public static int fib(int n) {

        if (n <= 2) {

            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}
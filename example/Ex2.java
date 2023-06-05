//Написать алгоритм поиска простых чисел (делятся только на себя и на 1)
// в диапазоне от 1 до N. В алгоритме будет использоваться вложенный
// for, что явно говорит о квадратичной сложности



package org.example;

public class Ex2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 35; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(i + " ");
            }
        }
    }
}

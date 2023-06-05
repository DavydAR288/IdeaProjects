//Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N.
// Согласно свойствам линейной сложности,
// количество итераций цикла будет линейно изменяться относительно изменения размера N.


        package org.example;

public class Ex1 {
    public static void main(String[] args) {
        int number=12;
        int total=0;
        for (int i=0; i<=number; i++) {
            total+=i;
        }
        System.out.println("total = " + total);
        int total2 = (number * (number + 1)) / 2;
        System.out.println("total2 = " + total2);
    }
}

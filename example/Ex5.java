//Пишем алгоритм поиска нужного числа последовательности Фибоначчи,
// но в этот раз откажемся от рекурсии и воспользуемся обычным алгоритмом, что даст нам линейную сложность,
// т.к. вычисление каждого из чисел последовательности будет происходить ровно 1 раз.


package org.example;

public class Ex5 {

    public static void main(String[] args) {
        fib(10);
    }
    public static void fib(int num) {
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
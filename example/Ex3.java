//Необходимо написать алгоритм поиска всех доступных комбинаций (посчитать количество) для 4 кубиков с количеством граней N.
//Данное решение имеет сложность O(n4), но если количество кубиков сделать переменной,
// то она трансформируется в O(nk), что будет представлять собой экспоненциальную сложность.

package org.example;

public class Ex3 {

    public static void main(String[] args) {
        System.out.println(countCube(6));
    }

    private static int countCube(int k) {
        int result = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < k; l++) {
                    for (int m = 0; m < k; m++) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
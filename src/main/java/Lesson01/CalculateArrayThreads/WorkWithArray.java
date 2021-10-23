package Lesson01.CalculateArrayThreads;

import java.util.concurrent.RecursiveTask;

public class WorkWithArray {

    // метод однопоточного вычисления суммы элементов массива
    public int sumArray(int calcArray[]) {
        int sum = 0;
        for (int i = 0; i < calcArray.length; i++) {
            sum = sum + calcArray[i];

        }
        return sum;

    }
    // Среднеарифметическое элементов массива
    public double middleArith(int sum, int length) {
        double middle;
        middle = sum / length;
        return middle;

    }
}

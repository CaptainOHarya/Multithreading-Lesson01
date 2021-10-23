package Lesson01.CalculateArrayThreads;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorkWithArray workWithArray = new WorkWithArray();
        // Это наш массив случайных чисел
        int[] calcArray;
        ValueSumCounter counter;
        // Переменная размера нашего массива
        int capacity;
        // Переменная верхней границы нашего массива
        int limit;
        // Это сумма элементов нашего массива при однопоточном вычислении
        int sum;
        // Это сумма элементов нашего массива при многопоточном вычислении
        int sumThreads;
        // Это среднеафиметическое элементов нашего массива
        double arithMean;

        System.out.println("Доброго времени суток!!! Это калькулятор массива");

        try {
            System.out.println("Введите размер массива:");
            capacity = scanner.nextInt();
            System.out.println("Введите верхнюю границу значений элементов в массиве:");
            limit = scanner.nextInt();
            if (capacity <= 0 || limit <= 0) {
                System.out.println("Числа должны быть целыми и положительными");

            }
            // Сначало необходимо сгенерировать наш массив
            calcArray = CreateArray.getInitArray(capacity, limit);
            // Можно вывести наш массив при желании, но он может быть очень большим,
            // поэтому оставим это как возможность
            /* System.out.print("[ ");
            for (int i = 0; i < capacity; i++) {

                System.out.print(calcArray[i] + " ");
            }
            System.out.print("]"); */

            // это для вычисления времени выполнения программы
            long l = System.currentTimeMillis();
            sum = workWithArray.sumArray(calcArray);
            System.out.println("");
            System.out.println("Сумма элементов массива при однопоточном вычислении: " + sum);
            arithMean = workWithArray.middleArith(sum, calcArray.length);
            System.out.println("Среднеарифметическое суммы элементов массива: " + arithMean);
            System.out.println(
                    "Время расчёта в миллисекундах: " + (double) (System.currentTimeMillis() - l));

            // это для вычисления времени выполнения программы
            long m = System.currentTimeMillis();
            counter = new ValueSumCounter(calcArray);
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            System.out.println("Сумма элементов массива при многопоточном вчислении " + forkJoinPool.invoke(counter));
            System.out.println(
                    "Время расчёта в миллисекундах: " + (double) (System.currentTimeMillis() - m));

        } catch (NumberFormatException err) {
            System.out.println("Число должно быть целым и положительным");

        }

        scanner.close();

    }
}



package Lesson01.CalculateArrayThreads;

import java.util.Random;

public class CreateArray {
    public static int[] getInitArray(int capacity, int limit) {
        Random rand = new Random();

        int mas[] = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            mas[i] = rand.nextInt(limit);

        }
        return mas;
    }

}

package Lesson01.CalculateArrayThreads;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ValueSumCounter extends RecursiveTask<Integer> {

    private int[] calcArray;

    public ValueSumCounter(int[] calcArray) {
        this.calcArray = calcArray;
    }

    @Override
    protected Integer compute() {
        if (calcArray.length <= 2) {

            return Arrays.stream(calcArray).sum();
        }
        ValueSumCounter firstHalfArrayValueSumCounter = new ValueSumCounter(Arrays.copyOfRange(calcArray, 0, calcArray.length / 2));
        ValueSumCounter secondHalfArrayValueSumCounter = new ValueSumCounter(Arrays.copyOfRange(calcArray, calcArray.length / 2, calcArray.length));
        firstHalfArrayValueSumCounter.fork();
        secondHalfArrayValueSumCounter.fork();
        return firstHalfArrayValueSumCounter.join() + secondHalfArrayValueSumCounter.join();
    }
}

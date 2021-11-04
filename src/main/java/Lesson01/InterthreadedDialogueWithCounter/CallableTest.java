package Lesson01.InterthreadedDialogueWithCounter;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> myCallable1 = new MyFuture(1000, "Поток № 1");
        Callable<Integer> myCallable2 = new MyFuture(1000, "Поток № 2");
        Callable<Integer> myCallable3 = new MyFuture(1000, "Поток № 3");
        Callable<Integer> myCallable4 = new MyFuture(1000, "Поток № 4");

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Collection<Callable<Integer>> taskList = new ArrayList<>();
        taskList.add(myCallable1);
        taskList.add(myCallable2);
        taskList.add(myCallable3);
        taskList.add(myCallable4);

        System.out.println("Старт исполнения Всех задач!!!");
        List<Future<Integer>> futures = executor.invokeAll(taskList);


        Integer countOfMessages = 0;
        int countOfThreads = 1;// это переменная для обозначения № потока, наверно можно было не делать
        for (Future future : futures) {
            countOfMessages = countOfMessages + (Integer) future.get();
            System.out.println("Поток №" + countOfThreads + " послал " + (Integer) future.get() + " сообщений");
            countOfThreads++;
        }

        System.out.println("Общее количество высланных сообщений = " + countOfMessages);

        System.out.println();
        System.out.println("Старт исполнения задач и получения результата от самой быстрой из них!!!");
        Integer futuresForInvokeAny = executor.invokeAny(taskList);
        System.out.println("Самый быстрый завершившийся поток послал " + futuresForInvokeAny + " сообщений");

        executor.shutdown();

        System.err.println("Всем спасибо, программа завершает свою работу!!!");

    }
}

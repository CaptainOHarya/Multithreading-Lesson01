package Lesson01.InterthreadedDialogueWithCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
    static int count = 4;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<String>> taskList = new ArrayList<>();
        for (int i = 0; i < count; i++) {

            taskList.add(executor.submit(new MyFuture(1000, "Поток №" + i)));
        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException ex) {
            ;
        }
        executor.shutdown();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ;
        }

        for (Future<String> task : taskList) {
            try {
                System.out.println(task.get());

            } catch (InterruptedException | ExecutionException ex) {
                System.out.println(ex);
            }
        }
    }
}

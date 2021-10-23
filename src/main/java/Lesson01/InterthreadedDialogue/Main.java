package Lesson01.InterthreadedDialogue;

public class Main {
    static int count = 4;

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Группа тестирования потоков");
        MyThread[] threads = new MyThread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new MyThread("Я поток №:" + i, 2500, threadGroup);
            threads[i].start();
        }
        try {
            Thread.sleep(15000);
        } catch (InterruptedException ex) {

        }
        threadGroup.interrupt();

    }
}
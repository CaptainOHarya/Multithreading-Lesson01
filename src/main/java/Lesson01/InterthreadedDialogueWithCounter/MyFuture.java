package Lesson01.InterthreadedDialogueWithCounter;

import java.util.concurrent.Callable;

class MyFuture implements Callable<String> {
    private final long waitTime;
    private String name;
    // так у нас случайным образом будет определяться количество сообщений, которые пошлёт поток
    private final int count = (int) (Math.random() * 10 + 3);

    public MyFuture(long waitTime, String name) {

        this.waitTime = waitTime;
        this.name = name;
    }

    @Override
    public String call() {
        try {
            for (int i = 0; i < count; i++) {

                System.out.printf("%s работает\n", name);
                Thread.sleep(waitTime);
            }
        } catch (InterruptedException ex) {
            // не будем обрабатывать
        } finally {
            System.out.printf("\t%s завершен\n", name);
        }
        return name + " послал " + count + " сообщений\n";
    }
}

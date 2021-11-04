package Lesson01.InterthreadedDialogueWithCounter;

import java.util.concurrent.Callable;

class MyFuture implements Callable<Integer> {
    private final long waitTime;
    private String name;
    // так у нас случайным образом будет определяться количество сообщений, которые пошлёт поток
    private final int count = (int) (Math.random() * 10 + 3);

    public MyFuture(long waitTime, String name) {

        this.waitTime = waitTime;
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        Integer tasksCount = 1;// Количество сообщений, которые в итоге пошлёт поток
        for (int i = 0; i < count; i++) {
            System.out.println("Привет! Я " + name + ", Я работаю и высылаю сообщение №" + i);
            Thread.sleep(waitTime);
            tasksCount++;
        }

        return tasksCount - 1;//т.к. последнее прибавление не должно учитываться, без -1 количество
        // сообщений будет на 1 больше, что не верно
    }

}

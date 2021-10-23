package Lesson01.InterthreadedDialogue;

class MyThread extends Thread {
    private final long waitTime;

    public MyThread(String name, long time, ThreadGroup threadGroup) {
        super(threadGroup, name);
        this.waitTime = time;
    }

    @Override
    public void run() {
        try {
            while (!this.isInterrupted()) {
                System.out.printf(" %s Всем привет!\n", this.getName());
                Thread.sleep(waitTime);
            }
        } catch (InterruptedException ex) {

        } finally {

            System.out.printf("Завершаю все потоки. %s завершен\n", this.getName());
        }
    }
}


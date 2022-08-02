package threads.creation.extendthread;

public class PrintHelloWorld extends Thread {

    @Override
    public void run() {
        System.out.println("Hello World [Thread: " +
                Thread.currentThread().getName() + "]");
    }
}

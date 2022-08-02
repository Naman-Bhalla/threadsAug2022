package threads.creation.runnable;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main method thread name = " + Thread.currentThread().getName());

        PrintHelloWorld printHelloWorld = new PrintHelloWorld();

        Thread t = new Thread(printHelloWorld);
        t.setName("Harikrishna");
        t.start();
    }
}

package threads.creation.extendthread;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main method thread name = " + Thread.currentThread().getName());

        PrintHelloWorld printHelloWorld = new PrintHelloWorld();
//        printHelloWorld.run(); -> NOT WORK

//        OPTION 1:
//        printHelloWorld.start();

//        OPTION 2:
//        Thread t = new Thread(printHelloWorld);
//        t.start();

        printHelloWorld.start();
        printHelloWorld.run();
    }
}

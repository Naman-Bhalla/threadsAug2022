package threads.print100.method2;

public class PrintNumber implements Runnable {
    private int numberToPrint;

    public PrintNumber(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println(numberToPrint + " Printed via thread: [" + Thread.currentThread().getName() + "]");
    }
}

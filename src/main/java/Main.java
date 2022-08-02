public class Main {

    public static void printHelloClass() {
        System.out.println("Hello Class [Thread Name: " + Thread.currentThread().getName() + "]");
    }

    public static void main(String[] args) {
        System.out.println("Hello World [Thread Name: " + Thread.currentThread().getName() + "]");
        printHelloClass();
    }
}

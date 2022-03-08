package java8lambdabasicsunit3;

public class MethodReferenceExample1 {
    public static void main(String[] args) {
        //Thread t = new Thread(() -> printMessage());
        /* Replacing with method reference */
        Thread t = new Thread(MethodReferenceExample1::printMessage);
        t.start();
    }

    public static void printMessage(){
        System.out.println("Hello");
    }
}

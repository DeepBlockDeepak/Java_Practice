package java8lambdabasics;

public class HelloWorldGreeting implements Greeting {

    @Override
    public void perform() {
        System.out.println("Hello world!");
    }
}

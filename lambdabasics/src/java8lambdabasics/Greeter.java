package java8lambdabasics;

public class Greeter {

    public void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
        greeter.greet(helloWorldGreeting);

        myLambda myLambdaFunction = () -> System.out.println("Hello world!");
        MyAdd addFunction = (int a, int b) -> a + b;
        // left off in video 8 at 5:50

    }

    interface myLambda {
        void arbitrary_func();
    }
    interface MyAdd{
        int arbitary_add_func(int x, int y);
    }
}

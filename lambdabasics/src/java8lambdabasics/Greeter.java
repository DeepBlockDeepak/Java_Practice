package java8lambdabasics;
// Java 8 Lambda Basics 9 - Lambdas vs Interface Implementations video
public class Greeter {

    public void greet(Greeting greeting){
        greeting.perform();
    }


    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        // Don't need the following instance method because the anonymous inner class method or the lambda work
        //Greeting helloWorldGreeting = new HelloWorldGreeting();
        Greeting lambdaGreeting = () -> System.out.println("Hello world!");

        // anonymous inner class method
        Greeting innerClassGreeting = new Greeting(){
            public void perform(){
                System.out.println("Hello world!");
            }
        };


        greeter.greet(lambdaGreeting);
        greeter.greet(innerClassGreeting);


    }

}


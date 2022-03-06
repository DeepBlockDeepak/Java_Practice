package java8lambdabasicsunit2;
// Java 8 Lambda Basics 17 - Exception Handling in Lambdas

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

    // Create a lambda which takes in an array of ints and an integer key \
    // for doing a mathematical operation ( + or / )

    public static void main(String[] args) {
        int[] someNumbers = {1,2,3,4};
        int key = 0;

        // Using Addition
        process(someNumbers, key, (i, k) -> {

            {
                try{
                    System.out.println(i / k);
                }
                catch(ArithmeticException e){
                    System.out.println(e.getMessage() + " Ya fuckin ding dong, you can't divide by 0");
                }
            }
        });
        System.out.println();


        /* USE THE WRAPPER LAMBDA TO BETTER HANDLE THE TRY/CATCH */
        process(someNumbers, key, wrapperLambda((i, k) -> System.out.println(i/k)));

    }

    // testing this|
    private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer){
        for(int i : numbers){
            consumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
        return (v,k) -> {
            try{
                consumer.accept(v,k);
            }
            catch(ArithmeticException e){
                System.out.println(e.getMessage() + " Error Caught in the WrapperLambda");
            }

        };

    }



}







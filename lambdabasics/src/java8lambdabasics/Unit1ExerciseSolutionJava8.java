package java8lambdabasics;

import java.util.*;
import java.util.function.Predicate;

public class Unit1ExerciseSolutionJava8 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // Step 1: Sort the people list by last name
        //Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        System.out.println("Printing the People() list, sorted by last name.");
        // Step 2 : using just one print function, with lambda returning true for every element
        printConditionally(people, p -> true);System.out.println();


        System.out.println("Printing only People() with last name starting with 'C'");
        // Step 3: Create a method that prints all people that have a last name beginning with 'C'
        printConditionally(people, p -> p.getLastName().startsWith("C"));System.out.println();

        System.out.println("Printing only People() with first name starting with 'C'");
        printConditionally(people, p -> p.getFirstName().toLowerCase().startsWith("c"));


    }

    /*
    // Step 2: Create a method that prints all elements in the list
    public static void printAll(List<Person> people){
        for(Person p: people){
            System.out.println(p);
        }
    }
    */

    // Step 3
    // TODO Note: built-in Predicate<T> allows the bypass of the Condition interface
    public static void printConditionally(List<Person> people, Predicate<Person> condition){
        for(Person p: people){
            if(condition.test(p)){
                System.out.println(p);
            }
        }
    }

}



package java8lambdabasicsunit2;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java8lambdabasics.Person;

public class StandardFunctionalInterfacesExample {

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

        // Step 2 : using just one print function, with lambda returning true for every element
        System.out.println("Printing the People() list, sorted by last name.");
        performConditionally(people, p -> true, p -> System.out.println(p));
        System.out.println();

        // Step 3: Create a method that prints all people that have a last name beginning with 'C'
        System.out.println("Printing only People() with last name starting with 'C'");
        performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p) );
        System.out.println();

        System.out.println("Printing only People() with first name starting with 'C'");
        performConditionally(people, p -> p.getFirstName().toLowerCase().startsWith("c"), p -> System.out.println(p.getFirstName()) );


    }

    // Step 3
    // TODO Note: built-in Predicate<T> allows the bypass of the Condition interface
    public static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
        for(Person p: people){
            if(predicate.test(p)){
                consumer.accept(p);
            }
        }
    }


}



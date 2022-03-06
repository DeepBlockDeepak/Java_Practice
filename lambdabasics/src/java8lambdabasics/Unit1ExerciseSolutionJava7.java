package java8lambdabasics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolutionJava7 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // Step 1: Sort the people list by last name
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        System.out.println("Printing the People() list, sorted by last name.");
        // Step 2
        printAll(people);System.out.println();

        System.out.println("Printing only People() with last name starting with 'C'");
        // Step 3: Create a method that prints all people that have a last name beginning with 'C'
        printConditionally(people, new Condition(){
            @Override
            public boolean test(Person p) {
                return p.getLastName().startsWith("C");
            }
        });
        System.out.println();


        System.out.println("zazkk".compareTo("z"));
        

    }


    // Step 2: Create a method that prints all elements in the list
    public static void printAll(List<Person> people){
        for(Person p: people){
            System.out.println(p);
        }
    }

    // Step 3
    public static void printConditionally(List<Person> people, Condition condition){
        for(Person p: people){
            if(condition.test(p)){
                System.out.println(p);
            }
        }
    }

}

interface Condition{
    boolean test(Person p);
}

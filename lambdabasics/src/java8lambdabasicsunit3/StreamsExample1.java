package java8lambdabasicsunit3;

import java8lambdabasics.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample1 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        //Print names that begin with "C"
        people.stream()
                .filter(p -> p.getLastName().startsWith("C"))
                .forEach(p -> System.out.println(p.getFirstName()));

        long countOfCPeople = people.stream()
                .filter(p -> p.getFirstName().startsWith("C"))
                .count();

        System.out.printf(
                "---%d People have first name starting with 'C' ---\n",
                countOfCPeople
        );



        List<Person> filteredPeople = people.stream()
                .filter(p -> p.getFirstName().startsWith("Charles"))
                .collect(Collectors.toList());


        System.out.println(filteredPeople.get(0).getFirstName());
    }
}

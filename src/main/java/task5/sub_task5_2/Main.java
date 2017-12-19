package task5.sub_task5_2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("Person",22, Person.SEX.FEMALE),
                    new Person("Person2",21, Person.SEX.MALE),
                    new Person("Person3",12, Person.SEX.FEMALE),
                    new Person("Person4",29, Person.SEX.MALE)
        );

        System.out.println("Ready to go to army ");
        personList.stream().filter((p) -> p.getAge() > 18).forEach(System.out::println);

        System.out.println("The average age by female");
        System.out.println(personList.stream().filter((x) -> x.getSex() == Person.SEX.FEMALE).
                mapToDouble(Person::getAge).average());

    }
}

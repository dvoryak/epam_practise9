package task234;

import com.sun.tools.javac.util.Convert;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task2");
        //9.2
        Integer[] ints = new Integer[50];
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new Random().nextInt(100);
            char c = (char) (new Random().nextInt(122 - 97) + 97);
            stringList.add(Character.toString(c));
        }
        System.out.println("Initial array: " + Arrays.toString(ints));
        System.out.println("Initial string " + stringList);

        Arrays.sort(ints,(i1,i2) -> (i2.compareTo(i1)));
        Collections.sort(stringList,(s1,s2) -> (s2.compareTo(s1)));

        System.out.println("Sorted array: " + Arrays.toString(ints));
        System.out.println("Sorted string list: " + stringList);

        //9.3
        System.out.println("Task3");
        System.out.println("Sum where x > 95 = " + getElements(ints, (x) -> x > 95));
        System.out.println("Start with a " + Arrays.toString(getStringWhichStartWith(stringList.toArray(new String[]{}), "a")));

        //9.4
        System.out.println("Task4");
        StringConverter stringConverter = String::toUpperCase;
        for (int i = 0; i < stringList.size(); i++) {
            stringList.set(i,stringConverter.convert(stringList.get(i)));
        }
        System.out.println(stringList);

    }

    // 9.3
    public static Integer getElements(Integer[] array, Predicate<Integer> predicate) {
        int sum = 0;
        for (Integer integer : array) {
            if(predicate.test(integer))
                sum += integer;
        }
        return sum;
    }

    public static String[] getStringWhichStartWith(String[] array, String startWith) {
        return Stream.of(array).filter((x)->x.startsWith(startWith)).collect(Collectors.toList()).toArray(new String[]{});
    }

    // 9.4
    @FunctionalInterface
    static interface StringConverter {

        String convert(String s);

        static boolean isExist(String s) {
            return s != null;
        }
    }

}

package task5.sub_task_5_1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> collect = Stream.iterate(10, (i) -> i + 10).limit(10).map((i) -> i = i / 2).collect(Collectors.toList());

        System.out.println(collect);
    }
}

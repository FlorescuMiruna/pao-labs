package pao.list;

import pao.IntegerComparator;

import java.util.*;

public class Example2 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(1);
        numbers.add(2);
        numbers.add(5);
        numbers.add(3);
        numbers.add(7);
        numbers.add(0);

        Collections.sort(numbers);
        System.out.println(numbers);

        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println(numbers);

        numbers.sort(new IntegerComparator());
        System.out.println(numbers);


    }
}

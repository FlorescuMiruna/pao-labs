package pao.map;

import pao.IntegerComparator;
import pao.Person;

import java.util.HashMap;
import java.util.Map;
public class Example1 {
    public static void main(String[] args) {
        Map<String, Person> personHashMap = new HashMap<>();
        Person p1 = new Person("Flavia", 18);
        personHashMap.put("12345678", new Person("Marius",37));
        personHashMap.put("34567890", new Person("Daniel",40));
        personHashMap.put("09826255", new Person("Flavius",39));

        System.out.println(personHashMap.get("12345678"));

        // elemente cu aceeasi cheie
        personHashMap.put("09826255",p1);
        System.out.println(personHashMap.get("09826255"));

        personHashMap.remove("09826255");
        for (Map.Entry<String, Person> pair : personHashMap.entrySet()) {
            System.out.print("Key: " + pair.getKey() + "; value: " + pair.getValue() + "\n");
        }

        System.out.println("Keyset: ");
        System.out.println(personHashMap.keySet());

        System.out.println("Values: ");
        System.out.println(personHashMap.values());

        // Mereu folositi obiecte imutabile pe post de chei!!
        Map<Person, Integer> map = new HashMap<>();
        Person p2 = new Person("Ioana",18);
        map.put(p1, 2);
        map.put(p2, 3);
        System.out.println(map.get(p2));

        p2.setName("Another");
        System.out.println(map.get(p2));
        System.out.println(map);



    }

}

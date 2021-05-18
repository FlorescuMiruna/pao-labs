package pao.example;

import java.util.Arrays;
import java.util.Comparator;

public class Student {
    private String name;
    private int age;

    public Student() {

    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Student[] students = {new Student("Maria", 20)};

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        Arrays.sort(students,(o1,o2) -> o1.getAge() - o2.getAge());
    }

    public static String test() {
        return "test";
    }
}

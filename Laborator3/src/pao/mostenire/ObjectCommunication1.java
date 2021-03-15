package pao.mostenire;

public class ObjectCommunication1 {
    public static void main(String[] args) {
        Student s1 = new Student("Alexandra");

        Student[] students = {s1};

        Department d1 = new Department("IT",students);
    }
}

class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Department{

    private String name;
    private Student []students;

    public Department(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void setStudents(Student[] students) {
        this.students = students;
    }
    public Student[] getStudents() {
        return students;
    }
}

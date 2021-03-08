package pao.homework;

/* . Write a program to create a Person object, with the following attributes: name as string,
 surname as string, age as int, identity number as long, type as string. Define a constructor for
 this class as well as accessors and mutators for all the attributes. Create two objects of type
 Person and display the information for them on separate lines.*/

public class Person {



    private String name;
    private String surname;
    private int age;
    private long ID;
    private String personType;

    static int numberOfPersons;

    public Person()
    {

        this.name = "";
        this.surname = "";
        this.age = 0;
        ID = ++numberOfPersons;

    }

    public Person(String name, String surname,int age,String personType)
    {

        this.name = name;
        this.surname = surname;
        this.age = age;
        this.personType = personType;
        ID = ++numberOfPersons;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public long getID() {
        return ID;
    }

    public String getType() {
        return personType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public void setType(String type) {
        this.personType = type;
    }


    public String toString(){
      return   "ID: " + ID + ", Name: " + this.name
              + ", Surname: " + this.surname + ", Age: "
              + this.age +  ", Type: " + personType;
    }
}

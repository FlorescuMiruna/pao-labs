package pao.biblioteca.entity;

import java.util.ArrayList;

public class Reader {

    public String name;
    public int age;

    //protected Book[] books;

    private ArrayList<Book> books;

    public Reader() {
        this.name = "";
        this.age = 0;
        this.books = null;
    }

    public Reader(String name, int age, ArrayList<Book> books) {
        this.name = name;
        this.age = age;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

//    public Book[] getBooks() {
//        return books;
//    }
    public ArrayList<Book> getBooks() {
        return books;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public void setBooks(Book[] books) {
//        this.books = books;
//    }
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }



    public String toString(){
        return "*** Name: " + name + ", age: " + age + " ***";
    }

}
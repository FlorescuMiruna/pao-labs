package pao.biblioteca;

public class Reader {

    public String name;
    public int age;

    protected Book[] books;

    public Reader() {
        this.name = "";
        this.age = 0;
        this.books = null;
    }

    public Reader(String name, int age, Book[] books) {
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

    public Book[] getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }




    public String toString(){
        return "*** Name: " + name + ", age: " + age + " ***";
    }

}
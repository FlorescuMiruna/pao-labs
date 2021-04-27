package pao.biblioteca;

import java.util.ArrayList;

public class AdultReader extends Reader {

    private String email;

    public AdultReader(String email) {
        this.email = email;
    }

    public AdultReader(String name, int age, ArrayList<Book> books, String email) {
        super(name, age, books);
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String toString(){
        return "*** Name: " + name + ", age: " + age + ", email: " + email + " ***";
    }
}

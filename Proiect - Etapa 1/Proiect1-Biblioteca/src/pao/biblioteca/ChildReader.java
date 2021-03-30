package pao.biblioteca;

public class ChildReader extends Reader{

    private String parentPhoneNumber;

    public ChildReader(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public ChildReader(String name, int age, Book[] books, String parentPhoneNumber) {
        super(name, age, books);
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public String getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public String toString(){
        return "*** Name: " + name + ", age: " + age + ", parent phone number: " + parentPhoneNumber + " ***";
    }
}

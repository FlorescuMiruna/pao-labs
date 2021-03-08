package pao.homework;

/* Write a program to create an object Subject with the following attributes: room as Room,
noOfStudents as integer, teacher as Person. Define a constructor for this class as well as
accessors and mutators for all the attributes. Create two objects of type Subject and display the
information for them on separate lines.*/

public class Subject {
    private Room room;
    private Integer noOfStudents;
    private Person teacher;


    public Subject(){
        this.room = new Room();
        this.noOfStudents = 0;
        this.teacher = new Person();

    }
    public Subject(Room room, Integer noOfStudents, Person teacher) {
        this.room = room;
        this.noOfStudents = noOfStudents;
        this.teacher = teacher;
    }
    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setNoOfStudents(Integer noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public Integer getNoOfStudents() {
        return noOfStudents;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public Person getTeacher() {
        return teacher;
    }

    public String toString(){
        return   "Room: " + room
                + "\nNumber of students: " + this.noOfStudents
                + "\nTeacher: " + this.teacher + "\n";
    }



}





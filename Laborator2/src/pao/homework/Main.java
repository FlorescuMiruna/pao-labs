package pao.homework;


public class Main {

    public static void main(String[] args) {

        //Exercitiul 1

        System.out.println("\n* Person *\n");

        Person person1 = new Person("Ana","Popescu",20,"Feminin");
        System.out.println(person1);

        Person person2 = new Person();
        person2.setType("Masculin");
        person2.setName("Ciobanu");
        person2.setSurname("Marius");
        person2.setAge(37);

        System.out.println(person2);


        //Exercitiul 2
        System.out.println("\n* Room *\n");

        Room room1 = new Room();
        room1.setRoomNumber(1);
        room1.setRoomType("Single");
        room1.setFloor(10);

        Room room2 = new Room(2,"Double",4);

        System.out.println(room1);
        System.out.println(room2);



        //Exercitiul 3
        System.out.println("\n* Subject *\n");

        Subject subject1 = new Subject();
        subject1.setRoom(room1);
        subject1.setNoOfStudents(30);
        subject1.setTeacher(person1);


        Subject subject2 = new Subject(room2,35,person2);

        System.out.println(subject1);
        System.out.println(subject2);

        //Exercitiul 4

        System.out.println("\n* School Principal *\n");

        SchoolPrincipal p = SchoolPrincipal.getSchoolPrincipal();
        SchoolPrincipal q= SchoolPrincipal.getSchoolPrincipal();

        p.showSchoolPrincipal();

        System.out.println(p == q);



    }
}

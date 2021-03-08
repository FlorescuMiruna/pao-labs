package pao.classes;

public class Animal {
    int noOfLegs = 4;

    // good practice: fields should be private, and should have public getters/setters

    private String sound;
    private String name;
    private int age;



    public Animal(int noOfLegs){

        this.noOfLegs = noOfLegs;
        System.out.println("Animal has " + noOfLegs + " legs.");

    }

    //supraincarcare constructor
    public Animal(String name, String sound){
        //this call must be first statement
        this(sound); //constructor chaining
        this.name = name;
    }

    public Animal(String sound){
        this.sound = sound;
    }

    public void animalSound(){
        System.out.println("The animal makes a sound: " + this.sound);
    }
    public void printName() {
        System.out.println("This animal's name is: " + this.name);
    }

    // supraincarcarea (overloading) a metodei printName
    public void printName(String name) {
        System.out.println("I wish my animal's name were: " + name + " but is: " + this.name);
    }

    public void printName(String name, int age) {
        System.out.println("I wish my animal's name were: " + name + " but is: " + this.name + " and his age is: " + age);
    }
    public void move(){
        System.out.println("I can walk!");
    }
    //getters and setters; Intelij command ALT + INSERT

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public String getSound() {
        return sound;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

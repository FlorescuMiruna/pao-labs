package pao.classes;

public class VisitToFarm {
    public static void main(String[] args) {
        Animal animal = new Animal("Nero","ham");
        animal.animalSound();
        animal.printName("Balto");
        animal.printName("Balto",17);
        animal.move();



        System.out.println(animal.noOfLegs);
        System.out.println(animal.getNoOfLegs());

        Bird bird = new Bird("chip-chip");
        System.out.println("The bird has " + bird.noOfLegs + " legs.");
        System.out.println("The bird has " + bird.getNoOfLegs() + " legs.");
        System.out.println("The bird has " + bird.getNoOfLegsFromParent() + " legs.");

        Animal a0 = new Animal(6);
        Animal a1 = new Animal("Max", "ham-ham");
        Animal a2 = new Animal("Max", "ham");
        Animal a3 = a1;

        //EQUSLD
        // if we don't override .equals(), it compares the reference (same as "==")

        System.out.println(a1.equals(a2));
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a3));
        System.out.println(a1 == a3);

        Cat c1 = new Cat("Ozi","meow",CatBreed.BRITISH_SHORT_HAIR);
        Cat c2 = new Cat("Ozi","meow",CatBreed.BRITISH_SHORT_HAIR);
        Cat c3 = c1;

        System.out.println("\n*Cats*\n");
        System.out.println(c1.equals(c2));
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c1.equals(c3));

        Cat c4 = new Cat("Ozi","meooow",CatBreed.BRITISH_SHORT_HAIR);
        System.out.println(c1.equals(c4));

        // OVERRIDE
        // printName method overridden in cat
        a1.printName();
        c1.printName();
        bird.printName();

        a1.move();
        c1.move();
        bird.move();

        System.out.println(a1.toString());
        System.out.println(c1.toString());

    }
}

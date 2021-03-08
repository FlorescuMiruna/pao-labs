package ro.unibuc.pao.io;

import java.util.Scanner;

public class ReadingAndWriting {

    public static void main(String[] args) {

        // The Scanner class id useful when reading values
        Scanner scanner;

        // set to read from the System console
        scanner = new Scanner(System.in);

        System.out.println("Input text:");

        String string = scanner.nextLine();
        System.out.println(string);

        System.out.println("Read boolean: ");
        // It can read booleans
        boolean b = scanner.nextBoolean();

        // numeric types
        System.out.println("Read int: ");
        int i = scanner.nextInt();

        System.out.println("Read double: ");
        double d = scanner.nextDouble();

        System.out.println("End of reading");


        // System.err.print("Something bad has happened\n");
        // System.err.println("Same as before, with a \\n at the end");

    }
}

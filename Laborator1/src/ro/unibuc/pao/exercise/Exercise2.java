package ro.unibuc.pao.exercise;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {



        /* 2. Scrieți un program care sa compare doua numere a și b citite de la tastatura
        si sa afiseze numarul mai mare. */

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.print("a: ");
        int a = scanner.nextInt();

        System.out.print("b: ");
        int b = scanner.nextInt();

        if(a > b)
            System.out.println("Numarul mai mare este: " + a);
        else
            System.out.println("Numarul mai mare este: " + b);




    }
}


package pao.homework;

import pao.practice.Calculator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
2. Sa se scrie un program care citeste de la tastura perechi de numere in care primul trebuie sa fie
mai mic decat al doilea. Daca nu se indeplineste conditia, sa se semnaleze exceptia si sa se
trateze prin cererea altei perechi de numere. Toate perechile care indeplinesc conditia se vor
scrie intr-un fisier.
 */


public class Ex2 {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Numarul de perechi: ");
        int n = scanner.nextInt();


        while (n > 0) {

            System.out.print("x: ");
            int x = scanner.nextInt();
            System.out.print("y: ");
            int y = scanner.nextInt();

            Perechi perechi = new PerechiImpl();
            try {

                    perechi.afis(x, y);

            } catch (Perechi.BadInputException e) {
                System.out.println(e.getMessage());
            } finally {

                n--;

            }

        }

    }
}

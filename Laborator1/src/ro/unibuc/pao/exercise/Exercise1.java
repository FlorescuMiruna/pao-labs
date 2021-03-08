package ro.unibuc.pao.exercise;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {

      /* 1. Scrieti un program care sa afișeze toate numerele pare din intervalul [0,n],
        unde n este un numar citit de la tastatura. */

        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.print("n: ");

        int n = scanner.nextInt();

        for(int i = 0;i<=n ;i += 2)
            System.out.print(i + " ");

        System.out.println('\n');



    }
}

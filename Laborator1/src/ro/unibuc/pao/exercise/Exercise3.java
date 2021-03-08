package ro.unibuc.pao.exercise;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        /* 3. Scrieți o metoda care sa calculeze factorialul unui numar n citit de la tastatura.*/

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.print("n: ");

        int n = scanner.nextInt();
        // System.out.println(n);

        int nFact = 1;

        for(int i=1; i<=n; i++)
        {
            nFact = nFact * i;}

        System.out.println("n factorial: " + nFact);
    }
}

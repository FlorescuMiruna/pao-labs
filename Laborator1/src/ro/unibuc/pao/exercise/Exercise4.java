package ro.unibuc.pao.exercise;

import java.util.Scanner;

public class Exercise4 {
    /* 4. Fiind dat un numar n, scrieti o metoda care insumeaza toti multiplii de 3 si 5 pana la n (inclusiv).*/

    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.print("n: ");
        int n = scanner.nextInt();

        int sum = 0;
        for(int i = 0;i <= n; i++)
            if(i % 3 == 0 || i % 5 == 0)
                sum += i;


        System.out.println("Suma este: " + sum);
    }


}

package ro.unibuc.pao.exercise;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        /* 5. Cititi de la tastatura n numere. Elementele citite vor fi organizate
        in doi vectori diferiti, in functie de paritate
        (de ex: elementele pare in vectorul x, iar cele impare in vectorul y).*/

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.print("Numarul elementelor: ");

        int nr = scanner.nextInt();

        int x[] = new int[nr+3];
        int y[] = new int[nr+3];

        int n = 0, m = 0;
        for(int i = 0;i < nr;i++)
        {
            System.out.print("Element " + (i+1) + ": ");
            int element = scanner.nextInt();

            if(element % 2 == 0)
                x[n++] = element;
            else
                y[m++] = element;


        }

        System.out.println("Vectorul x: ");
        for(int i = 0; i < n; i++)
            System.out.print(x[i] + " ");

        System.out.println();

        System.out.println("Vectorul y: ");
        for(int i = 0; i < m; i++)
            System.out.print(y[i] + " ");



    }
}

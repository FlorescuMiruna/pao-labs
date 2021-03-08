package ro.unibuc.pao.exercise;
import java.util.Scanner;


public class Exercise6 {

    public static void main(String[] args) {

  /*  6. Cititi de la tastatura n note, numere intregi, intr-un vector. Cand cititi valoarea -1 de la tastatura, citirea
    notelor se opreste si programul afiseaza media acestora.*/

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.print("n: ");

        int n = scanner.nextInt();
        int suma = 0, nr =0;

        while (n != 0)
        {
            System.out.print("Introduceti nota: ");
            int nota = scanner.nextInt();

            if(nota == -1) {
                break;
            }

            else
            {
                nr++;
                suma += nota;
            }

            n--;
        }

        if(nr != 0)
            System.out.println("Media notelor este: " + suma/nr);
        else
            System.out.println("Nu se poate calcula media!");

    }
}

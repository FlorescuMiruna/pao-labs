package ro.unibuc.pao.exercise;
import java.util.Scanner;


public class Exercise7 {
    public static void main(String[] args) {
        /*7. Sa se afiseze al n-lea termen din seria Fibonacci, unde n este citit de la tastatura.*/

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.print("n: ");
        int n = scanner.nextInt();

        int fibo1 = 1,fibo2 = 1,fiboNr = 0;

        if(n == 0)
            fiboNr = 0;
        else if (n <= 2)
            fiboNr = 1;

        else
        {
            int m = n;
            while (m-2 != 0)
            {
                fiboNr = fibo1 + fibo2;
                fibo1 = fibo2;
                fibo2 = fiboNr;
                m--;
            }
        }

        System.out.println("Al " + n + "-lea termen din sirul lui Fibonnaci este: " + fiboNr);
    }
}

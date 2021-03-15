package pao.homework.ex3;
import java.util.Arrays;
import java.util.Scanner;

public class Anagrame {
    public static void main(String[] args) {

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.print("Introduceti primul sir: ");
        String sir1 = scanner.nextLine();

        System.out.print("Introduceti al doilea sir: ");
        String sir2 = scanner.nextLine();


        Boolean suntAnagrame = true;
        int n = sir1.length();
        int m = sir1.length();

        if(n != m)
            suntAnagrame = false;

        else{
            char array1[] = sir1.toCharArray();
            char array2[] = sir2.toCharArray();

            Arrays.sort(array1);
            Arrays.sort(array2);

            for(int i = 0 ;i < n; i++)
                if(array1[i] != array2[i]){
                    suntAnagrame = false;
                    break;
                }


            }

        if (suntAnagrame){
            System.out.println("Sirurile sunt anagrame.");
        }
        else{
            System.out.println("Sirurile nu sunt anagrame.");
        }


    }
}

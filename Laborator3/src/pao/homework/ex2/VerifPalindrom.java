package pao.homework.ex2;
import java.util.Scanner;

public class VerifPalindrom {
    public static void main(String[] args) {

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.print("Introduceti sirul: ");
        String sir = scanner.nextLine();


        int i = 0, j = sir.length()-1;

        Boolean isPalindrome = true;

        while (i <= j){
            if(sir.charAt(i) != sir.charAt(j)){

                isPalindrome = false;
                break;
            }
            i++;
            j--;

        }

        if(isPalindrome)
            System.out.println("Sirul este palindom.");
        else
            System.out.println("Sirul nu este palindrom.");




    }
}

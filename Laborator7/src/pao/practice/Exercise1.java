package pao.practice;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
/**
 * Cititi de la stdin o linie de text si scrieti-o in fisier.
 * Nu uitati sa afisati un mesaj sugestiv in cazul aparitiei unei exceptii si sa inchideti resursa dupa terminarea folosirii acesteia.
 */
public class Exercise1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti linia: ");
        String linie = scanner.next();

        writeUsingFileWriter(linie);
    }

    public static void writeUsingFileWriter(String linie) {
        try (FileWriter fileWriter = new FileWriter("ex1.txt")) {
            fileWriter.append(linie);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}

package pao.biblioteca;

import pao.biblioteca.exceptions.FileReadingException;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromCSVFileService {
    /***
     *  **Serviciu pentru citirea din fisier**
     *  Avem 4 fisiere de tip CSV din care vom citi: Author.csv,Book.csv,AudioBook.csv,PrintedBook.csv
     *  Dupa ce am citit din fisierul de tip CSV, intoarcem informatia sub forma unei liste de liste,
     *  cate o lista pentru fiecare coloana din fisier
     */
    public static ArrayList<ArrayList<String>> readFromAuthorFile(String file_path) throws FileReadingException {


        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> nationalities = new ArrayList<String>();
        ArrayList<ArrayList<String> > authors = new ArrayList<ArrayList<String> >();

        String line = "";
        try {
            file_path = "CSV_files\\" + file_path;
            BufferedReader buffer = new BufferedReader(new FileReader(file_path));

            while ((line = buffer.readLine()) != null) {
                String[] column = line.split(",");

                names.add(column[0]);
                nationalities.add(column[1]);

            }


        } catch (FileNotFoundException e) {
            throw new FileReadingException("Something went wrong in readFromAuthorFile method", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        names.remove(0);
        nationalities.remove(0);
        authors.add(names);
        authors.add(nationalities);
        return authors;
    }
    public static ArrayList<ArrayList<String>> readFromBookFile(String file_path) throws FileReadingException {


        ArrayList<String> years = new ArrayList<String>();
        ArrayList<String> titles = new ArrayList<String>();
        ArrayList<ArrayList<String> > books = new ArrayList<ArrayList<String> >();

        String line = "";
        try {
            file_path = "CSV_files\\" + file_path;
            BufferedReader buffer = new BufferedReader(new FileReader(file_path));

            while ((line = buffer.readLine()) != null) {
                String[] column = line.split(",");

                years.add(column[0]);
                titles.add(column[1]);

            }


        } catch (FileNotFoundException e) {
            throw new FileReadingException("Something went wrong in readFromBookFile method", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        years.remove(0);
        titles.remove(0);
        books.add(years);
        books.add(titles);
        return books;
    }

    public static ArrayList<ArrayList<String>> readFromPrintedBookFile(String file_path) throws FileReadingException {


        ArrayList<String> years = new ArrayList<String>();
        ArrayList<String> titles = new ArrayList<String>();
        ArrayList<String> pages = new ArrayList<String>();
        ArrayList<ArrayList<String> > books = new ArrayList<ArrayList<String> >();

        String line = "";
        try {
            file_path = "CSV_files\\" + file_path;
            BufferedReader buffer = new BufferedReader(new FileReader(file_path));

            while ((line = buffer.readLine()) != null) {
                String[] column = line.split(",");

                years.add(column[0]);
                titles.add(column[1]);
                pages.add(column[2]);

            }


        } catch (FileNotFoundException e) {
            throw new FileReadingException("Something went wrong in readFromPrintedBookFile method", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        years.remove(0);
        titles.remove(0);
        pages.remove(0);
        books.add(years);
        books.add(titles);
        books.add(pages);
        return books;
    }
    public static ArrayList<ArrayList<String>> readFromAudioBookFile(String file_path) throws FileReadingException {


        ArrayList<String> years = new ArrayList<String>();
        ArrayList<String> titles = new ArrayList<String>();
        ArrayList<String> hours = new ArrayList<String>();
        ArrayList<ArrayList<String> > books = new ArrayList<ArrayList<String> >();

        String line = "";
        try {
            file_path = "CSV_files\\" + file_path;
            BufferedReader buffer = new BufferedReader(new FileReader(file_path));

            while ((line = buffer.readLine()) != null) {
                String[] column = line.split(",");

                years.add(column[0]);
                titles.add(column[1]);
                hours.add(column[2]);

            }


        } catch (FileNotFoundException e) {
            throw new FileReadingException("Something went wrong in readFromAudioBookFile method", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        years.remove(0);
        titles.remove(0);
        hours.remove(0);
        books.add(years);
        books.add(titles);
        books.add(hours);
        return books;
    }


}

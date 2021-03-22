package pao.comparatori;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class Book implements Comparable<Book>{

    private int year;
    private String name;
    private String author;

    public Book(int year, String name, String author){

        this.year = year;
        this.name = name;
        this.author = author;
    }

    public int getYear(){
        return year;
    }
    public String getName(){
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Book book){

               /*
        * Returns:
        * - positive integer, if the current object is greater than the
        specified object.
        * - negative integer, if the current object is less than the
        specified object.
        * - zero, if the current object is equal to the specified object.
        */

        return this.year - book.year;
    }

    public static void main(String[] args) {

        Book prideAndPrejudice = new Book(1900,"Pride and Prejudice","Jane Austen");
        Book senseAndSensibility = new Book(1910,"Sense and Sensibility","Jane Austen");
        Book greatExpectations = new Book(1861,"Great Expectations","Charles Dickens");




        Book[] books = new Book[]{prideAndPrejudice, senseAndSensibility,greatExpectations};

        // Using comparable
        Arrays.sort(books);

        for (Book book : books){
            System.out.println(book.getName() + "-" + book.getYear());
        }

        System.out.println();

        // Using comparator

        NameComparator nameCompare = new NameComparator();
        Arrays.sort(books,nameCompare);

        for (Book book : books){
            System.out.println(book.getName() + "-" + book.getYear());
        }

        System.out.println();

        YearComparator yearComparator = new YearComparator();
        Arrays.sort(books,yearComparator);


        for (Book book : books){
            System.out.println(book.getName() + "-" + book.getYear());
        }

        System.out.println();

        AuthorComparator authorComparator = new AuthorComparator();
        Arrays.sort(books,authorComparator);

        for (Book book : books){

            System.out.println(book.getName() + "-" + book.getYear()+ "-" + book.getAuthor());
        }


    }


}

package pao.biblioteca;


import pao.biblioteca.exceptions.FileReadingException;
import pao.biblioteca.exceptions.FileWritingException;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {



    public static void main(String[] args) throws FileWritingException, FileReadingException {


        ArrayList<ArrayList<String> > myAuthors = new ArrayList<ArrayList<String> >();

        /**Incarcam datele din fisier folosind clasa-serviciu */

        myAuthors = ReadFromCSVFileService.readFromAuthorFile("Author.csv");
        System.out.println(myAuthors);



        Author camus = new Author(myAuthors.get(0).get(0), myAuthors.get(1).get(0));
        Author rowling = new Author(myAuthors.get(0).get(1), myAuthors.get(1).get(1));
        Author hesse = new Author(myAuthors.get(0).get(2), myAuthors.get(1).get(2));
        Author harari = new Author(myAuthors.get(0).get(3), myAuthors.get(1).get(3));

        Section classics = new Section("Classics");
        Section fantasy = new Section("Fantasy");


        ArrayList<ArrayList<String> > myBooks = new ArrayList<ArrayList<String> >();
        ArrayList<ArrayList<String> > myPrintedBooks = new ArrayList<ArrayList<String> >();
        ArrayList<ArrayList<String> > myAudioBooks = new ArrayList<ArrayList<String> >();
        // Incarcam datele din fisier folosind clasa-serviciu
        myBooks = ReadFromCSVFileService.readFromBookFile("Book.csv");
        myPrintedBooks = ReadFromCSVFileService.readFromBookFile("PrintedBook.csv");
        myAudioBooks = ReadFromCSVFileService.readFromBookFile("AudioBook.csv");

        System.out.println(myBooks);
        System.out.println(myPrintedBooks);
        System.out.println(myAudioBooks);

        Book book1 = new Book(Integer.parseInt(myBooks.get(0).get(0)),myBooks.get(1).get(0),classics,camus);
        Book book2 = new AudioBook(1927,"Lupul de stepa",classics,hesse,7);
        Book book3 = new PrintedBook(1997,"Harry Potter ",classics,rowling,400);
        Book book4 = new AudioBook(1942,"Mitul lui Sisif",classics,camus,6);

        BookService bookService = new BookService(); // Ne folosim de clasa serviciu pentru Book

        bookService.changeSection(book3,fantasy); // Ii schimbam Sectiunea cartii
        System.out.println(book3);

        bookService.displayBookAge(book1); // Ne calzuleaza si afiseaza vechimea unei carti

        System.out.println("This book must be returned within "      // Calzuleaza zilele in care o carte trebuie returnata
                        + bookService.calculateDaysAvailable(book1) + " days.\n");



        ArrayList<Book> books = new ArrayList<>(Arrays.asList(book1, book2, book4));

        bookService.getBooksByAuthor(books,camus); // Cartile scrise de un anumit autor

        Reader ana = new Reader("Ana", 20,books);
        Reader andrei = new AdultReader("Andrei", 20,books,"andrei@gmail.com");
        Reader daniel = new ChildReader("Daniel", 10,books,"0737665509");

        Reader readers[] = new Reader[]{ana,andrei,daniel};

        ReaderService readerService = new ReaderService(); //Ne folosim de clasa serviciu pentru Reader

        readerService.addBook(andrei,book3); // Adaugam o carte in lista de carti imprumutate ale cititorului


        readerService.sortBooks(andrei); // Sortam (dupa anul aparitiei) lista de carti a cititorului

        //Books borrowed by the reader, sorted by year:
        readerService.printReader(andrei,"reader_sorted.txt");


        //Books borrowed by the reader, after removing the last one:
        readerService.removeBook(andrei); // Stergem ultima carte imprumutata de citior
        readerService.printReader(andrei, "reader_after_removing.txt");

        //Books borrowed by the reader, after removing all of them
        readerService.removeAllBooks(andrei); // Stergem toate cartile imprumutate de cititor
        readerService.printReader(andrei,"reader_empty.txt");


        readerService.getReadersByAge(readers,20,"readers_by_age.txt"); // Imi afiseaza toti cititorii care au varsta data de mine


        readerService.sortReadersAlphabetically(readers); // Sorteaza cititorii alfabetic

        String output = "The readers from our library, alphabetically sorted:\n\n";

        for (Reader reader : readers){
            output += reader.toString() + "\n";
        }

        WriteToFileService.writeUsingFileOutputStream(output,"readers_sorted.txt");


    }
}

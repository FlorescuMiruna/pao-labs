package pao.biblioteca;


import pao.biblioteca.databaseServices.*;
import pao.biblioteca.entity.*;

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



        /** DE AICI INCEPEM SA FOLOSIM BAZA DE DATE*/

        AuthorDatabaseService authorDatabaseService = new AuthorDatabaseService();
        SectionDatabaseService sectionDatabaseService = new SectionDatabaseService();
        BookDatabaseService bookDatabaseService = new BookDatabaseService();
        ReaderDatabaseService readerDatabaseService = new ReaderDatabaseService();



        /**  Stergem toate tabelel in caz ca acestea exista*/

        readerDatabaseService.dropTable();
        bookDatabaseService.dropTable();
        authorDatabaseService.dropTable();
        sectionDatabaseService.dropTable();

        System.out.println();

        // AUTHOR

        authorDatabaseService.createTable();

        authorDatabaseService.insertAuthor("Charlote Bronte","English");
        authorDatabaseService.displayAuthor(1); // Vrem sa ne afiseze autorul cu un anumit id

        authorDatabaseService.updateAuthor("Emil Cioran","Romanian",1); // Vrem sa inlocuim datele despre autorul cu un anumit id cu cela date ca parametru
        authorDatabaseService.displayAuthor(1);

        authorDatabaseService.insertAuthorsFromCSVFile(); // Inseram in baza de date toti autorii din fisierul de tip CSV

        authorDatabaseService.deleteAuthor(4); // Stergem autorul cu un anumit id

        authorDatabaseService.displayAllAuthors(); // Imi scrie in fisier toti autorii din tabela



        // SECTION

        sectionDatabaseService.createTable();
        sectionDatabaseService.insertSection("Classics");
        sectionDatabaseService.displaySection(1);

        sectionDatabaseService.insertSection("Fiction");
        sectionDatabaseService.displaySection(2);
        sectionDatabaseService.updateSection("SF",2);
        sectionDatabaseService.displaySection(2);

        sectionDatabaseService.insertSection("Philosophy");
        sectionDatabaseService.insertSection("Non-fiction");
        sectionDatabaseService.insertSection("Fantasy");

        sectionDatabaseService.deleteSection(2);

        sectionDatabaseService.displayAllSections();


        //BOOK

        bookDatabaseService.createTable();

        bookDatabaseService.insertBook(1947,"Ciuma",3,2);
        bookDatabaseService.insertBook(1937,"Lacrimi si sfinti",3,1);
        bookDatabaseService.displayBook(2);

        bookDatabaseService.updateBook(2011,"Sapiens",4,5,2);
        bookDatabaseService.displayBook(2);

        bookDatabaseService.deleteBook(2);
        bookDatabaseService.displayAllBooks();

        bookDatabaseService.insertBook(1996,"Urzeala tronurilor",5,6);
        bookDatabaseService.insertBook(2018,"Foc si sange",5,6);

        bookDatabaseService.displayAllBooks();

        // READER

        readerDatabaseService.createTable();

        readerDatabaseService.insertReader("Ana",25,1);
        readerDatabaseService.displayReader(1);

        readerDatabaseService.updateReader("Maria",25,1,1);
        readerDatabaseService.displayReader(1);

        readerDatabaseService.insertReader("Marian",40,3);
        readerDatabaseService.deleteReader(1);

        readerDatabaseService.displayAllReaders();



   }

}

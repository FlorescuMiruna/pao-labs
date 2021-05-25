package pao.biblioteca;


import pao.biblioteca.comparatori.NameComparator;
import pao.biblioteca.entity.*;
import pao.biblioteca.exceptions.FileReadingException;
import pao.biblioteca.exceptions.FileWritingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReaderService {


    public void addBook(Reader reader, Book book) {

        /** Am inlocuit array-urile din etapa anterioara cu colectii */

        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("addBook");

        ArrayList<Book> books = reader.getBooks();
        books.add(book);
        reader.setBooks(books);

    }

    public void sortBooks(Reader reader) {

        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("sortBooks");

        ArrayList<Book> books = reader.getBooks();
        Collections.sort(books);
        reader.setBooks(books);

    }

    public void removeBook(Reader reader) {

        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("removeBook");

        ArrayList<Book> books = reader.getBooks();
        int n = books.size();
        books.remove(n-1); // Stergem cartea de pe ultima pozitie

        reader.setBooks(books);

    }

    public void removeAllBooks(Reader reader) {

        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("removeAllBooks");

        ArrayList<Book> books = reader.getBooks();
        books.clear();
        reader.setBooks(books);

    }

    void printReader(Reader reader, String path)throws FileWritingException, FileReadingException {

        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("printReader");


        String output = "";

        output += reader.toString() + "\n\n";
        if( reader.getBooks().size() == 0){
            output = "There are no more borrowed books!";
        }


        for (Book book : reader.getBooks()) {

            output += book.toString();

        }
        WriteToFileService.writeUsingFileWriter(output,path);


    }

    public void sortReadersAlphabetically(Reader reders[]){

        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("sortReadersAlphabetically");


        NameComparator nameCompare = new NameComparator();
        Arrays.sort(reders,nameCompare);



    }

    public void getReadersByAge(Reader readers[], int age,String path)throws FileWritingException, FileReadingException{

        AuditService auditService = new AuditService();
        auditService.WriteActionsToCSVFile("getReadersByAge");

        String output = "The readers whose age is " + age + ":\n\n";

        for(int i=0;i<readers.length;i++)
            if(readers[i].getAge() == age){
                output += readers[i].toString() + "\n";
            }
        WriteToFileService.writeUsingBufferedOutputStream(output, path);


    }

}

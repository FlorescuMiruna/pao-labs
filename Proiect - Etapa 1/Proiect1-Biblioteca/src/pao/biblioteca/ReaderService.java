package pao.biblioteca;

import java.util.Arrays;

public class ReaderService {


    public void addBook(Reader reader, Book book) {

        Book[] books = reader.getBooks();
        int n = books.length;
        Book[] new_books = new Book[n+1];

        for (int i = 0 ;i < n ; i++){
            new_books[i] = books[i];
        }
        new_books[n] = book;
        reader.setBooks(new_books);

    }

    public void sortBooks(Reader reader) {

        Book[] books = reader.getBooks();
        Arrays.sort(books);
        reader.setBooks(books);

    }

    public void removeBook(Reader reader) {

        Book[] books = reader.getBooks();
        int n = books.length;
        Book[] new_books = new Book[n-1];

        for (int i = 0 ;i < n-1 ; i++){
            new_books[i] = books[i];
        }

        reader.setBooks(new_books);

    }

    public void removeAllBooks(Reader reader) {

        Book[] books = reader.getBooks();
        int n = books.length;
        Book[] new_books = new Book[0];

        reader.setBooks(new_books);

    }

    void printReader(Reader reader) {



        System.out.println(reader);
        if( reader.getBooks().length == 0){
            System.out.println("There are no more borrowed books!\n");
        }

        for (int i = 0; i < reader.getBooks().length; i++) {

            System.out.println(reader.getBooks()[i].toString());
        }
    }

    public void sortReadersAlphabetically(Reader reders[]){

        NameComparator nameCompare = new NameComparator();
        Arrays.sort(reders,nameCompare);



    }

    public void getReadersByAge(Reader readers[], int age){


        for(int i=0;i<readers.length;i++)
            if(readers[i].getAge() == age){
                System.out.println(readers[i]);
            }

    }

}

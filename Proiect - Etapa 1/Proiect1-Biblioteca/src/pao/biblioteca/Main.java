package pao.biblioteca;


public class Main {



    public static void main(String[] args) {

        Author camus = new Author("Alber Camus", "french");
        Author rowling = new Author("J. K. Rowling", "british");
        Author hesse = new Author("Herman Hesse", "german");

        Section classics = new Section("Classics");
        Section fantasy = new Section("Fantasy");

        Book book1 = new Book(1947,"Ciuma",classics,camus);
        Book book2 = new AudioBook(1927,"Lupul de stepa",classics,hesse,10);
        Book book3 = new PrintedBook(1997,"Harry Potter ",classics,rowling,400);
        Book book4 = new AudioBook(1942,"Mitul lui Sisif",classics,camus,7);

        BookService bookService = new BookService(); // Ne folosim de clasa serviciu pentru Book

        bookService.changeSection(book3,fantasy); // Ii schimbam Sectiunea cartii
        System.out.println(book3);

        bookService.displayBookAge(book1); // Ne calzuleaza si afiseaza vechimea unei carti

        System.out.println("This book must be returned within "      // Calzuleaza zilele in care o carte trebuie returnata
                        + bookService.calculateDaysAvailable(book1) + " days.\n");


        Book books[] = new Book[]{book1,book2,book4};

        bookService.getBooksByAuthor(books,camus); // Cartile scrise de un anumit autor

        Reader ana = new Reader("Ana", 20,books);
        Reader andrei = new AdultReader("Andrei", 20,books,"andrei@gmail.com");
        Reader daniel = new ChildReader("Daniel", 10,books,"0737665509");

        Reader readers[] = new Reader[]{ana,andrei,daniel};

        ReaderService readerService = new ReaderService(); //Ne folosim de clasa serviciu pentru Reader

        readerService.addBook(andrei,book3); // Adaugam o carte in lista de carti imprumutate ale cititorului


        readerService.sortBooks(andrei); // Sortam (dupa anul aparitiei) lista de carti a cititorului

        System.out.println("Books borrowed by the reader, sorted by year:\n");
        readerService.printReader(andrei);


        System.out.println("Books borrowed by the reader, after removing the last one:\n");
        readerService.removeBook(andrei); // Stergem ultima carte imprumutata de citior
        readerService.printReader(andrei);

        System.out.println("Books borrowed by the reader, after removing all of them:\n");
        readerService.removeAllBooks(andrei); // Stergem toate cartile imprumutate de cititor
        readerService.printReader(andrei);



        readerService.getReadersByAge(readers,20); // Imi afiseaza toti cititorii care au varsta data de mine


        readerService.sortReadersAlphabetically(readers); // Sorteaza cititorii alfabetic

        System.out.println("\nThe readers from our library, alphabetically sorted:\n");
        for (Reader reader : readers){
            System.out.println(reader);
        }


    }
}

package pao.biblioteca;


public class BookService  {

    public void changeSection(Book book, Section section) {


        System.out.println("\nThis book has been moved from the '" +
                book.getSection() + "' section to the '" +section + "' section:\n");

        book.setSection(section);

    }

    public void getBooksByAuthor(Book books[], Author author){

        System.out.println("In our library you can find the following books, written by " + author.getName() + ":");
        for(int i=0;i<books.length;i++)
            if(books[i].getAuthor() == author){
                System.out.println(books[i].getName());
            }
        System.out.println();
    }

    public int calculateDaysAvailable(Book book){

        /** Calculam numarul de zile in care o carte poate fi returnata */

        int days = 0;

        if (book.getYear() < 1950){  // Cartile mai vechi trebuie returnate intr-o saptamana
            days = 5;
        }

        else{
            days = 14;  // Altfel, termenul este de 2 saptamani
        }


        if (book.getClass() == AudioBook.class){
            days -= 7;    // Pentru audiobook-uri ai la dispozitie cu o saptamana mai putin
        }

        if (book.getClass() == PrintedBook.class){
            if(book.getSection().equals( "Fantasy"))
            days += 7; // Pentru cartile Fantasy tiparite ai la dispozitie o saptamana mai mult
        }

        return days;


    }

    public void displayBookAge(Book book){
        int age = 2021 - book.getYear();
        System.out.println( book.getName()+  ": This book was written " + age + " years ago.");
    }


}








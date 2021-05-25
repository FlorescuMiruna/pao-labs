package pao.biblioteca.entity;

public class PrintedBook extends Book{

    protected int numberOfPages;

    PrintedBook(){
        numberOfPages = 0;
    }
    public PrintedBook(int year, String name, Section section, Author author, int numberOfPages) {

        super(year,name,section,author);
        this.numberOfPages = numberOfPages;

    }

    @Override
    public String toString(){
        return "Title: " + getName() + "\nAuthor: " + getAuthor() + "\nPublish year: "
                + getYear() + "\nSection: " + getSection() +"\n" + "Number of pages: " + numberOfPages + "\n~~~~~~~~~~~~~\n";
    }
}

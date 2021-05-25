package pao.biblioteca.entity;

public class Book implements Comparable<Book>{

    private int year;
    private String title;
    private Author author;
    private Section section;


    public Book(){
        this.year = 0;
        this.title = "";
        this.author = null;
        this.section = null;

    }
    public Book(int year, String name, Section section,Author author) {
        this.year = year;
        this.title = name;
        this.section = section;
        this.author = author;
    }


    public void setYear(int year) {
        this.year = year;
    }

    public void setName(String name) {
        this.title = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }
    public Section getSection() {
        return section;
    }


    public void setSection(Section section) {
        this.section = section;
    }

    public int compareTo(Book book){
        return this.year - book.year;
    }


    @Override
    public String toString(){
        return "Title: " + title + "\nAuthor: " + author + "\nPublish year: "
                + year + "\nSection: " + section +"\n~~~~~~~~~~~~~\n";
    }
}

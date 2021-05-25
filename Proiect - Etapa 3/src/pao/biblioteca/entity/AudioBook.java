package pao.biblioteca.entity;

public class AudioBook extends Book {


    private double numberOfHours;

    AudioBook(){
        numberOfHours = 0;
    }

    public double getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(double numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public AudioBook(int year, String name, Section section, Author author, double numberOfHours) {

        super(year,name,section,author);
        this.numberOfHours = numberOfHours;

    }

    @Override
    public String toString(){
        return "Title: " + getName() + "\nAuthor: " + getAuthor() + "\nPublish year: "
                + getYear() + "\nSection: " + getSection() +"\n" + "Number of hours: "
                + numberOfHours + "\n~~~~~~~~~~~~~\n";
    }
}

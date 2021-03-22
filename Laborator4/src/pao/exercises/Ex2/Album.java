package pao.exercises.Ex2;

public class Album implements Comparable<Album>{

    private String name;
    private String artist;
    private double rating;
    private int year;


    public Album() {
        this.name = "";
        this.artist = "";
        this.rating = 0;
        this.year = 0;
    }
    public Album(String name, String artist, double rating, int year) {
        this.name = name;
        this.artist = artist;
        this.rating = rating;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }


    @Override
    public int compareTo(Album album){

        return this.name.compareTo(album.name);
    }
}

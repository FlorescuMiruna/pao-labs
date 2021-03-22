package pao.Exercise.Ex2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("The Wall", "Pink Floyd",8.1,1982);
        Album album2 = new Album("Dark Side of the Moon", "Pink Floyd",8.6,1973);
        Album album3 = new Album("American Idiot", "Green day",7.1,2004);
        Album album4 = new Album("Master of Puppets", "Metallica",9,1986);

        Album[] albums = new Album[]{album1,album2,album3,album4};



        for (Album album : albums){
            System.out.println(album.getName() +  " - " + album.getYear() + ", " + album.getRating());
        }


        System.out.println("\n ~ Using comparable ~ \n");
        Arrays.sort(albums);

        for (Album album : albums){
            System.out.println(album.getName() +  " - " + album.getYear() + ", " + album.getRating());
        }

        System.out.println("\n ~ Sortare dupa nume ~\n");

        NameComparator nameCompare = new NameComparator();
        Arrays.sort(albums,nameCompare);


        for (Album album : albums){
            System.out.println(album.getName() +  " - " + album.getYear() + ", " + album.getRating());
        }

        System.out.println("\n ~ Sortare dupa anul publicarii ~\n");

        YearComparator yearCompare = new YearComparator();
        Arrays.sort(albums,yearCompare);


        for (Album album : albums){
            System.out.println(album.getName() +  " - " + album.getYear() + ", " + album.getRating());
        }

        System.out.println("\n ~ Sortare dupa rating ~\n");

        RatingComparator ratingComparator = new RatingComparator();
        Arrays.sort(albums,ratingComparator);


        for (Album album : albums){
            System.out.println(album.getName() +  " - " + album.getYear() + ", " + album.getRating());
        }


    }
}

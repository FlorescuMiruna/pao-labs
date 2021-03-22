package pao.exercises.Ex2;


import java.util.Comparator;

public class YearComparator implements Comparator<Album> {


    public int compare(Album o1, Album o2){

        return o1.getYear() - o2.getYear();
    }
}

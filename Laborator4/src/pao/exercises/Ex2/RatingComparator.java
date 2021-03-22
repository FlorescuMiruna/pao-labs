package pao.exercises.Ex2;

import java.util.Comparator;

public class RatingComparator implements Comparator<Album>{


    public int compare(Album o1, Album o2){

        return (int)(o1.getRating() - o2.getRating());
    }
}

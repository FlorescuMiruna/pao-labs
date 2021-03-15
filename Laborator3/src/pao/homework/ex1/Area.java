package pao.homework.ex1;

public class Area{

    private CandyBag candyBag;
    private int number;
    private String street;

    public Area() {
        this.candyBag = null;
        this.number = 0;
        this.street = "";
    }

    public Area(CandyBag candyBag, int number, String street) {
        this.candyBag = candyBag;
        this.number = number;
        this.street = street;
    }

    public void printAdress(){

        System.out.println("Adress: Str. " + street + ", number " + number);

        CandyBox [] candyBoxes = candyBag.getCandyBoxes();

        for (int i = 0; i < candyBoxes.length; i++){

            System.out.println(candyBoxes[i].toString());

        }



    }
}
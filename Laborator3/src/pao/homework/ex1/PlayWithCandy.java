package pao.homework.ex1;



public class PlayWithCandy {

    public static void main(String[] args) {

        CandyBox milka = new Milka("strawberries", "Belgia" ,15,10,3);
        CandyBox lindt = new Lindt("hazelnuts","Germania",12.5,3);
        CandyBox merci = new Merci("dark chocolate","Franta",10);

        CandyBox milka1 = new Milka("strawberries", "Belgia" ,15,10,3);
        CandyBox lindt1 = new Lindt("hazelnuts","Olanda",12.5,3);
        CandyBox merci1 = new Merci("dark chocolate","Franta",20);

        System.out.println(milka == lindt); // false
        System.out.println(milka.equals(lindt)); // false

        System.out.println(milka == milka1); // false
        System.out.println(milka.equals(milka1)); // true

        System.out.println(lindt.equals(lindt1)); // false , lindt1 are originea diferita
        System.out.println(merci.equals(merci1)); // false , merci1 are lungimea diferita

        CandyBox[] candyBoxes = {milka,lindt,merci};

        CandyBag bag = new CandyBag(candyBoxes);

        Area myArea = new Area(bag,25,"Unirii");

        myArea.printAdress();


    }

}

package pao.homework.ex1;



public class PlayWithCandy {

    public static void main(String[] args) {

        CandyBox a = new Milka("strawberries", "Belgia" ,15,10,3);
        CandyBox b = new Lindt("hazelnuts","Germania",12.5,3);
        CandyBox c = new Merci("dark chocolate","Franta",10);

        CandyBox a1 = new Milka("strawberries", "Belgia" ,15,10,3);



        System.out.println(a == b);
        System.out.println(a.equals(b));

        System.out.println(a == a1);
        System.out.println(a.equals(a1));



        CandyBox[] candyBoxes = {a,b,c};

        CandyBag bag = new CandyBag(candyBoxes);

        Area myArea = new Area(bag,25,"Unirii");

        myArea.printAdress();


    }

}

package ro.unibuc.pao.instructions;

public class Instructions {

    public static void main(String[] args) {


        if (1 < 2) {
            System.out.println("My math needs improving");
        } else {
            System.out.println("All is good");
        }


        //switch
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Never");
                break;
        }


        for (int i = 0, j = 4; i < 10 && j < 10; i++, j++) {
            System.out.println(i + " " + j);
        }

        int i = 0;
        while (i < 7) {
            i++;
            System.out.println("I am in while");
        }
        System.out.println("No while for me");


        do{
            i++;
            System.out.println(i);
        }while (i < 10);
    }
}

package pao.Exercise.Ex3;


public class Main {

    public static void main(String[] args) {

        var op = new Operation(0);

        op.minus(20);
        System.out.println(op);

        op.plus(30);
        System.out.println(op);

        op.div(4);
        System.out.println(op);

        op.mult(3);
        System.out.println(op);


    }
}

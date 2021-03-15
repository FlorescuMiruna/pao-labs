package pao.homework.ex4;

import java.util.Random;

public class PasswordMaker {

    private static final Integer MAGIC_NUMBER = 10;
    private final String MAGIC_STRING = generateRandomString(20);
    private String name;


    PasswordMaker(){

    }
    PasswordMaker(String name){
        this.name = name;
    }



    String generateRandomString(Integer n){
        String myAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";

        Random rand = new Random();

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {


            int index = rand.nextInt(myAlphabet.length()); //Generam random un index intre 0 si lungimea alfabetului

            sb.append(myAlphabet.charAt(index)); //Adaugam in string elementul din alfabet de pe pozitia generata random
        }

        return sb.toString();
    }

    String getPassword(){

        Random rand = new Random();

        String password = generateRandomString(MAGIC_NUMBER)
                +  MAGIC_STRING.substring(5,15)
                + name.length()
                + rand.nextInt(101);

        return password;
    }

    public static void main(String[] args) {
        PasswordMaker p = new PasswordMaker("Ana");
        PasswordMaker q = new PasswordMaker("Ana");

        System.out.println(p == q);

        System.out.println("Password: " + p.getPassword());

    }


}

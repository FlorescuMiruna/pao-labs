package pao.strings;

import java.util.Locale;

public class Test {

    public static void main(String[] args) {
        String s1 = "this is a string";
        String s2 = new String ("this is another string");

        s1.toUpperCase();
        System.out.println(s1.toUpperCase());

        s2.toUpperCase();
        System.out.println(s2);

        System.out.println(s1.length());
        System.out.println(s2.charAt(2));

        String[] strings = s1.split("");

        for(String string:  strings)
            System.out.println(string);

        String substring = s1.substring(2,7);
        System.out.println(substring);


        StringBuilder sb1 = new StringBuilder("Java");

        System.out.println(sb1);

        String sbToString = sb1.toString();

        System.out.println(sbToString);

        String s3 = " Love";
        sb1.append(s3);

        System.out.println(sb1);

        System.out.println(sb1.reverse().toString());

        sb1.substring(4);
        int foundAt = sb1.indexOf(s3);
        System.out.println(foundAt);

        System.out.println();
    }



}

package ro.unibuc.pao.arrays;

public class Example1 {
    public static void main(String[] args) {


        float values[] = new float[3];
        float [] values2 = new float[3];

        values[0] = 10.0f;
        values[1] = 20.0f;
        values[2] = 20.0f;

        float sum = 0.0f;

        for(int i=0;i < values.length;i++) {
            sum += values[i];
        }

        System.out.println("My sum with for: " + sum);

        for (float name : values) {
            sum += name;
        }

        System.out.println("My sum with enhanced for: " + sum);
    }
}

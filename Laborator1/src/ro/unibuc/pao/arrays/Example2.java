package ro.unibuc.pao.arrays;

public class Example2 {
    public static void main(String[] args) {
        float[] values = {10.0f,20.0f,15.0f};
        //automatically allocates the right number of spaces and initializes the value in each one of the spaces

        float sum = 0.0f;

        for(float x : values)
            sum += x;

        System.out.println(sum);
    }
}

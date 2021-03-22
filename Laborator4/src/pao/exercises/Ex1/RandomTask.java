package pao.exercises.Ex1;
import java.util.Random;

public class RandomTask implements Task{

    private Integer randomNumber;

    RandomTask(){

        Random rand = new Random();
        randomNumber = rand.nextInt();

        System.out.println("Constructorul RandomTask a fost apelat");
    }

    public void execute(){
        System.out.println("Numarul generat random este: " + randomNumber);
    }
}

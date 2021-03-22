package pao.Exercise.Ex1;

public class CounterOutTask implements Task{

    public static int counter;

    public CounterOutTask(){

        counter++;
        System.out.println("Constructorul CounterOutTask a fost apelat");
    }

    @Override
    public void execute() {
        System.out.println("Valoare contorului este: " + counter);
    }
}

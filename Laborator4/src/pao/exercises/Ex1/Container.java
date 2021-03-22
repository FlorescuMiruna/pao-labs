package pao.exercises.Ex1;

public class Container {
    public static void main(String[] args) {

        RandomTask randomTask = new RandomTask();
        OutTask outTask = new OutTask("Acesta este un mesaj");
        CounterOutTask counterOutTask = new CounterOutTask();

        CounterOutTask counterOutTask2 = new CounterOutTask();

        randomTask.execute();
        outTask.execute();
        counterOutTask.execute();

    }
}

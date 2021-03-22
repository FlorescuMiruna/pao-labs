package pao.Exercise.Ex1;

public class OutTask  implements Task {

    private String message;

    public OutTask(String message){

        this.message = message;
        System.out.println("Constructorul OutTask a fost apelat");

    }

    @Override
    public void execute(){
        System.out.println(message);
    }


}

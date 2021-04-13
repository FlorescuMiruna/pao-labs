package pao.homework;



public interface Perechi {

    class BadInputException extends Exception{
        BadInputException(String message){
            super(message);
        }
    }
    void afis (int x, int y) throws Perechi.BadInputException;
}

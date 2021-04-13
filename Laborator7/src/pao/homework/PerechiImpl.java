package pao.homework;


import java.io.FileWriter;
import java.io.IOException;

public class PerechiImpl implements Perechi{
    public static void writeUsingFileWriter(String text, boolean append){
        try(FileWriter fileWriter = new FileWriter("output.txt",append)){
            fileWriter.append(text);
            fileWriter.append("\n");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void afis(int x, int y) throws Perechi.BadInputException {
        if(x > y){
            throw new Perechi.BadInputException("Primul numar este mai mare decat cel de-al doilea!!!");

        }
        String text = "" + x + " " + y;
        writeUsingFileWriter(text, true);
    }
}

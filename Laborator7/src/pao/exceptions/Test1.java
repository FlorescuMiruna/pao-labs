package pao.exceptions;

class Base extends Exception{


}
class Derived extends Base{

}
public class Test1 {
    public static void main(String[] args) {
        try{
            throw new Derived();
        }
        catch (Derived d){
            System.out.println("Cought derived class exception");
        }
        catch (Base b){
            System.out.println("Cought base class exception");
        }
    }
}

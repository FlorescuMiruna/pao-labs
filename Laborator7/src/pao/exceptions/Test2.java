package pao.exceptions;

public class Test2 {
    String str = "a";

    void a(){
        try{
            str += "b";
            b();
        }catch (Exception e){
            str += " catch a ";
            str += "c";
        }
    }

    void b() throws Exception{
        try{
            str += "d";
            c();
        }catch (Exception e){
            str += " catch b " ;
            throw new Exception();
        }finally {
            str += "e";
        }
        str += "f";
    }
    void c() throws Exception{
        str += " catch c ";
        throw new Exception();
    }
    void display(){
        System.out.println(str);
    }

    public static void main(String[] args) {
        Test2 object = new Test2();
        object.a();
        object.display(); //abdef
    }
}

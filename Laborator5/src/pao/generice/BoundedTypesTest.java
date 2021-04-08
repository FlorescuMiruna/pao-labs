package pao.generice;

import java.util.ArrayList;
import java.util.List;

class Pizza{
    protected String name = "Pizza";
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                '}';
    }
}

class HamPizza extends Pizza{
    HamPizza(){
        name = "HamPizza";
    }
}
class CheesePizza extends Pizza{
    CheesePizza(){
        name = "CheesePizza";
    }
}
public class BoundedTypesTest {

    // Aici folosim "bounded types", accepta doar instante de Pizza sau copii ai clasei Pizza
    // Folosim upper bounds in general cand vrem sa parcurgem fara sa modificam o colectie: List<? extends Pizza> upperBoundPizzaList = new ArrayList<>();

    public static <T extends Pizza> void listPizza(T[] PizzaArray){
        System.out.println("We have all types of Pizza!");
        for(T t : PizzaArray){
            System.out.println(t.getName());

        }

    }

    public static void main(String[] args) {
        BoundedTypesTest.listPizza(new Pizza[]{new HamPizza(),new CheesePizza(), new Pizza()});


        // folosim lower bound in general cand vrem sa modificam o colectie
        List<? super HamPizza> lowerBoundPizzaList = new ArrayList<>();
        lowerBoundPizzaList.add(new HamPizza());
        System.out.println(lowerBoundPizzaList.toString());

    }
}

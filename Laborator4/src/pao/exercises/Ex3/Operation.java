package pao.exercises.Ex3;

public class Operation implements  Minus ,Plus{
    private float nr;

    public Operation(float nr) {
        this.nr = nr;
    }


    public float minus(float x){
        this.nr -= x;
        return this.nr;
    }

    public float plus(float x){
        this.nr += x;
        return this.nr;
    }

    public float div(float x){
        this.nr /= x;
        return this.nr;
    }
    public float mult(float x){
        this.nr *= x;
        return this.nr;
    }



    @Override
    public String toString() {
        return "Numarul dupa operatie: " + nr;
    }
}

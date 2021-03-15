package pao.homework.ex1;

class Lindt extends CandyBox{

    // Cilindru

    private double height,radius;

    Lindt(){
        this.height = 0;
        this.radius = 0;
    }

    Lindt(String flavor,String origin,double height,double radius){


        super(flavor,origin);
        this.height = height;
        this.radius = radius;
    }

    public double getVolume(){
        return Math.PI * radius * radius * height;
    }

    public String toString(){
        return "Lindt ~ The origin: " + getOrigin() + "; The flavor: " + getFlavor() + "; The volume: " + getVolume();
    }


}

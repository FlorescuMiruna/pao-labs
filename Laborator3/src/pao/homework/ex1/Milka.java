package pao.homework.ex1;

class Milka extends CandyBox{

    private double length, width, height;

    Milka(){
        this.length = 0;
        this.width = 0;
        this.height = 0;
    }

    Milka(String flavor,String origin,double length,double width, double height){

        super(flavor,origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getVolume(){
        return length * width * height;
    }
    public String toString(){
        return "Milka ~ The origin: " + getOrigin() + "; The flavor: " + getFlavor() + "; The volume: " + getVolume();
    }


}
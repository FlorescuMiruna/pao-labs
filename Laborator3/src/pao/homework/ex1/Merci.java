package pao.homework.ex1;

class Merci extends CandyBox{
    // Cub
    private double length;

    Merci(){
        this.length = 0;
    }

    Merci(String flavor, String origin, double length){
        super(flavor,origin);
        this.length = length;
    }
    public double getVolume(){

        return length * length * length;
    }
    public String toString(){
        return "Merci ~ The origin: " +
                getOrigin() + "; The flavor: " +
                getFlavor() + "; The volume: "
                + getVolume();
    }

}


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


    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }

        Merci merci = (Merci) obj;

        if( super.equals(merci) == false) //Verific daca sunt la fel campurile din parinte
            return false;

        if(this.length != merci.length)
            return false;

        return true;
    }

    public String toString(){
        return "Merci ~ The origin: " +
                getOrigin() + "; The flavor: " +
                getFlavor() + "; The volume: "
                + getVolume();
    }

}


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

        Milka milka = (Milka) obj;

        if( super.equals(milka) == false) //Verific daca sunt la fel campurile din parinte
            return false;

        if(this.length != milka.length)
            return false;

        if(this.height != milka.height)
            return false;

        if(this.width != milka.width)
            return false;


        return true;
    }

    @Override
    public double getVolume(){
        return length * width * height;
    }
    public String toString(){
        return "Milka ~ The origin: " + getOrigin() + "; The flavor: " + getFlavor() + "; The volume: " + getVolume();
    }


}
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

        Lindt lindt = (Lindt) obj;

        if( super.equals(lindt) == false) //Verific daca sunt la fel campurile din parinte
            return false;

        if(this.height != lindt.height)
            return false;

        if(this.radius != lindt.radius)
            return false;


        return true;
    }

    public String toString(){
        return "Lindt ~ The origin: " + getOrigin() + "; The flavor: " + getFlavor() + "; The volume: " + getVolume();
    }


}

package pao.homework.ex1;

abstract class CandyBox{

    private String flavor;
    private String origin;

    public CandyBox() {
        this.flavor = "";
        this.origin = "";
    }

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getOrigin() {
        return origin;
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

        CandyBox candyBox = (CandyBox) obj;

        if(this.flavor != candyBox.flavor)
            return false;

        if(this.origin != candyBox.origin)
            return false;

        return true;
    }

    @Override
    public String toString(){
        return null;
    }
    public abstract double getVolume();


}

package pao.classes;

public class Cat extends Animal{

    private CatBreed catBreed;

    public Cat(String name, String sound, CatBreed catBreed){
        super(name,sound);
        this.catBreed = catBreed;
    }

    public CatBreed getCatBreed() {
        return catBreed;
    }

    public void setCatBreed(CatBreed catBreed) {
        this.catBreed = catBreed;
    }
}

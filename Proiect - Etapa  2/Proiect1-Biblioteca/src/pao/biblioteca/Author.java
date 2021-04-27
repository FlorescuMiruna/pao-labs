package pao.biblioteca;

public class Author {

    public String name;
    public String nationality;


    public Author() {
        this.name = "";
        this.nationality = "";
    }

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString(){
        return "name: "+ name + ", nationality: " + nationality;
    }
}

package pao.biblioteca.entity;

public class Section {

    private String sectionName;

    public Section() {
        this.sectionName = "";
    }
    public Section(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
    @Override
    public String toString(){
        return  getSectionName();
    }
}

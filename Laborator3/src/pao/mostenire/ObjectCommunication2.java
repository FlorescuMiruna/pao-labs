package pao.mostenire;

public class ObjectCommunication2 {
    public static void main(String[] args) {
        Sale sale = new Sale(2);
        sale.addArticles("mouse");
        sale.addArticles("keyboard");
        sale.addArticles("headphones");
    }
}


class Sale{
    private Article[] articles;
    private int noOfArticles;
    private int currentNumber;

    public Sale(int noOfArticles) {
        this.articles = new Article[noOfArticles];
        this.noOfArticles = noOfArticles;

    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void addArticles(String name){
        if(currentNumber < noOfArticles) {
            this.articles[currentNumber++] = new Article(name);
        }else {
            System.out.println("Capacity is reached.");
        }



    }
}

class Article{
    private String name;

    public Article(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
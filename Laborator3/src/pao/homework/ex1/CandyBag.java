package pao.homework.ex1;

class CandyBag{

    private CandyBox[] candyBoxes;

    public CandyBag(CandyBox[] candyBoxes) {
        this.candyBoxes = candyBoxes;
    }

    public CandyBox[] getCandyBoxes() {
        return candyBoxes;
    }
}

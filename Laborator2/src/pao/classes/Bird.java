package pao.classes;

public class Bird extends Animal{

        int noOfLegs = 2;
        public Bird(String sound){
            super(sound);
        }

        //@Override
        public void printName(){
            System.out.println("Birds have no name!");
        }

        public void move(){
            System.out.println("I can fly!");
        }


        public int getNoOfLegsFromParent(){
            return super.getNoOfLegs();
        }

         //@Override
         public int getNoOfLegs() {
            return noOfLegs;
        }
}

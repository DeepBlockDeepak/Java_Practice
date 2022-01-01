// practice with classes

class Cat{
    // Instance fields:
    String noise= "uninitialized";
    int numLives = 9;
   
    // Constructor takes in one String parameter
    public Cat(String animalNoise){
        // Assign instance variable to parameter value:
        noise = animalNoise;
    }


    public void namePrinter(){
        System.out.println(noise);
    }
   
    public static void main(String[] args){
        // Send argument to constructor when creating an object:
        Cat firstCat = new Cat("dafuq"); 
        // Send argument to constructor when creating another object:
        Cat secondCat = new Cat("mow");

        firstCat.namePrinter(); // Prints: dafuq
        secondCat.namePrinter(); // Prints: mow
    }
}


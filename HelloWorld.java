/* 
What is this syntax doing?

A class whose name must match the .java filename is created.

Within this class, the driver function is found, I presume.

So how does the public class get called?

*/


/*
.length()
.concat()
.equals()
.equalsIgnoreCase()
.indexOf()
.charAt()
.substring()
.toUpperCase() / .toLowerCase()

String.valueOf(anIntVar or int)    String.valueOf(5.99) == "5.99"
SomeString.compareTo(SomeOtherString)   // obtains alphabetical ordering of the two Strings (greater than, less than, or equal to 0)
*/


public class HelloWorld{

    int x = 5;

    class Dog{
        int y = 66;
        int x;


        // Not sure what this does?
        public Dog(){
            x = 515;
            
        }
        
    }


    public static void main(String[] args){
        
        /*
        following used for testing out command line input and accepting as a variable 
        */
        // String name = args[0];
        //printer(name);
        
        String[] test_array = new String[] {"stuff", "blobs", "third object"};

        System.out.println(String.format("The test_array has %d elements.", test_array.length));    //using `String.format()` as an `f` string idea

        array_printer(test_array);

        Dog dog = new Dog();
        System.out.println("\n" + dog.x);

    }



    public static void printer(String printedWord){
        System.out.println("You just printed " + printedWord);
    }


    /**
     *  This function employs the ternary operation method for array printing 
     * 
     * @param arr The String array to be printed
     */
    public static void array_printer(String[] arr){
        
        System.out.println("{");
        for(int i = 0; i < arr.length; i++){
            System.out.println(
                i == arr.length -1  ? arr[i].toUpperCase() + "\n}"
                                    : arr[i] + ","
            );
        }
         
    }

    /* This Method DOESN'T WORK
            i == arr.length - 1 ? System.out.println(arr[i] + "\n}")
                                : System.out.println(", " + arr[i]);
    */




    
    /**
     *  
     *  STUDY HOW THIS ROTATION WORKS!!!!!!!!!!!!
     * 
     * @param groceryList
     */
    public static void rotateGroceries(String[] groceryList) {
        if (groceryList.length > 1) {
          String previous = groceryList[groceryList.length - 1];
          for (int i = 0; i < groceryList.length; i++) {
            String temp = groceryList[i];
            groceryList[i] = previous;
            previous = temp;
          }
        }
      }

}
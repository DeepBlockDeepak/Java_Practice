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

String.valueOf(anIntVar)    String.valueOf(5.99) == "5.99"
SomeString.compareTo(SomeOtherString)   // obtains alphabetical ordering of the two Strings (greater than, less than, or equal to 0)
*/


public class HelloWorld{




    public static void main(String[] args){
        
        String name = args[0];

        printer(name);
        
        String bob = "Bob";
        int i = 0;
        
        for(;i < 20; i++){
            bob = bob.concat("+-+" + i);
    
        }

        System.out.println(bob.length());

        
            
        //System.out.println(bob);
        //System.out.println(String.valueOf(i));  // conversion of int to String for printing

    }

    public static void printer(String printedWord){
        System.out.println("You just printed " + printedWord);
    }


}
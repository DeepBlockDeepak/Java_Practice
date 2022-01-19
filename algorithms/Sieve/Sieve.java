import java.util.*;
// class FindTrueIndices
class Sieve {

   void findTrueIndices(boolean[] arr) {
    
    // create `result` ArrayList
    ArrayList<Integer> result = new ArrayList<Integer>();
    
    // use for-loop to add index of `arr` elements to `result` that are `true` by calling `add()` method
    for(int i = 0; i < arr.length; i++){

        if(arr[i]){
            result.add(i);
        }

    }

    // Print `result`
    System.out.println(Arrays.toString(result.toArray()));
  }

  
  
  public static void main(String[] args) {
    Sieve myFindTrueIndices = new Sieve();
    boolean[] testValues = {false, false, true, true, false, true, false, true};
    myFindTrueIndices.findTrueIndices(testValues);
  }
}
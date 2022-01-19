import java.util.*;
// class FindTrueIndices
class Sieve {
  
  /**
   * Ongoing work::::::::::
   *
   * @Critical This function doesn't interact with a return variable, so it should be modified this way. 
   * Then, findTrueIndeces() can take the return array as a parameter, and print the corresponding boolean array from the existing logic   
   * 
   * @param limit the upperbound value of the user's inputted Sieve size
   */
  void sieveOfEratosthenes(int limit){
    boolean output[] = new boolean[limit + 1];

    for(int x = 0; x <= limit; x++){
      output[x] = true;
    }
    output[0] = false; output[1] = false;

    for(int i = 2; i <= limit; i++){

      if(output[i]){

        for(int j = i*2; j < limit; j += j + i){
          output[j] = false;
        }

      }

    }


  }
  
  /**
   * 
   * @param arr for mapping int array values to corresponding values in second bool array for indicating 
   *            prime(true)/composite(false) status
   */
  void findTrueIndices(boolean[] arr) {
    
    // create `result` ArrayList
    ArrayList<Integer> result = new ArrayList<Integer>();
    
    // use for-loop to add index of `arr` elements to `result` that are `true` by calling `add()` method
    for(int i = 0; i < arr.length; i++){
  
      if(arr[i]){
          result.add(i);
      }

  }
    
    /**
     * Are the following two commands distinguishable?
     */
    //System.out.println(result);
    System.out.println(Arrays.toString(result.toArray()));

    /*
    result.forEach(
      (temp) -> {System.out.print(temp);}
    );
    */
  }

  
  
  public static void main(String[] args) {

    Sieve myFindTrueIndices = new Sieve();
    boolean[] testValues = {false, false, true, true, false, true, false, true};
    myFindTrueIndices.findTrueIndices(testValues);
  }
}
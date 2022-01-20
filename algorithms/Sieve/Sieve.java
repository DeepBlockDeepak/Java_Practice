import java.util.*;

/**
 * Performs the Sieve of Eratosthenes method for returning prime numbers up to a User's selected integer.
 */
class Sieve {


  /**
   * @brief Creates a Boolean array where each index corresponds directly to that index's integer value i.e., the 5th index corresponds to
   *        the integer 5. 
   *        If integer n is prime, then output[n] will be assigned 'true'
   * 
   * @param limit the upperbound value of the user's inputted Sieve size
   * @return      returns the boolean array with correctly assigned Prime true/false values per the index value
   */
  static boolean[] sieveOfEratosthenes(int limit){
    // instantiate an boolean array which will map index values to prime/not-prime status
    boolean output[] = new boolean[limit + 1];

    // start with each element set to true, and hard code the compositeness off 0 and 1
    for(int x = 0; x <= limit; x++){
      output[x] = true;
    }
    output[0] = false; output[1] = false;

    // perform the Sieve operation
    for(int i = 2; i <= limit; i++){

      // if a prime is encountered, decertify all of its multiples
      if(output[i]){
        for(int j = i*2; j <= limit; j += i){
          output[j] = false;
        }
      }

    }
    return output;
  }
  


  /**
   * 
   * @param arr for mapping int array values to corresponding values in second bool array for indicating 
   *            prime(true)/composite(false) status
   */
  static void findTrueIndices(boolean[] arr) {
    
    // create `result` ArrayList
    ArrayList<Integer> result = new ArrayList<>();
    
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


  static void sieveArrayList(int limit){

    HashMap<Integer, Boolean> primeMap = new HashMap<>(limit + 1);

    // first assign 'true' to each value in the primeMap, except for where i == 0 || i == 1
    for(int i = 0; i <= limit; i++){
      //primeMap.put(i, true);
      if(i == 0 || i == 1){
        primeMap.put(i, false);  
      }
      else{
        primeMap.put(i, true);
      }
    }

    for(int i = 2; i <= limit; i++){

      // if a prime is encountered, decertify all of its multiples
      if(primeMap.get(i)){
        for(int j = i*2; j <= limit; j += i){
          primeMap.replace(j, false);
        }
      }

    }

    //System.out.println(primeMap.size());
    /*
    System.out.print("[");
    primeMap.forEach((key,bool_val) -> {
      System.out.print(
        bool_val  ?  key + ", "
                  : ""  
      );

    });
    */

    System.out.print("[");
    primeMap.forEach((key, bool_val) -> {

      if(key.equals(primeMap.size() - 1) && bool_val){
        System.out.println(key + "]");
      }
      else if(key.equals(primeMap.size() - 1) && !bool_val){
        System.out.println("]");
      }
      else if(bool_val){
        System.out.print(String.format("%d, ", key));
      }
      else{
        ;
      }

    });

    //System.out.println("]");

  }



  public static void main(String[] args) {

    int sieve_limit = args.length < 1 ? 100
                                      : Integer.valueOf(args[0]);

    //findTrueIndices(sieveOfEratosthenes(sieve_limit));

    sieveArrayList(sieve_limit);

  }
}
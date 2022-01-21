import java.util.*;

/**
 * Performs the Sieve of Eratosthenes method for returning prime numbers up to a User's selected integer.
 */
class Sieve {


  /**
   * 
   * @param limit User defined. The HashMap will contain keys up to and including the user's limit value
   * @return      Returns a HashMap with prime keys set to true, and composite keys set to false
   */
  static HashMap<Integer,Boolean> sieveHashMap(int limit){

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

    return primeMap;

  }


  /**
   * 
   * @param primeMap The HashMap with (int, bool) pairs; if an integer key is prime, then it's value will be true
   */
  static void sieveHashMapPrinter(HashMap<Integer, Boolean> primeMap){

    
    /**
     * Returning list of valid primes by creating 2 new Sets.
     * 'false_keys' stores only integers which are not primes
     * 'primes' first contains all of the primeMap integers, then removes the 'false_keys' values
    */
    Set<Integer> false_keys = new HashSet<>();

    for(Integer key : primeMap.keySet()){
      if(!primeMap.get(key)){
        false_keys.add(key);
      }
    }

    Set<Integer> primes = primeMap.keySet();

    primes.removeAll(false_keys);

    System.out.println(primes);   
    

    /**
     * Using Iterator to remove the key,value pairs 'in-place'
     */
    Iterator it = primeMap.entrySet().iterator();
    while(it.hasNext()){
      Map.Entry pair = (Map.Entry)it.next();
      //Integer key = (Integer)pair.getKey();
      Boolean value = (Boolean)pair.getValue();
      if(!value){
        it.remove();
      }
    }

    System.out.println(primeMap.keySet());

  }



  public static void main(String[] args) {
    

    try{
      
      int sieve_limit = args.length < 1 ? 100
                                        : Integer.valueOf(args[0]);
      

      HashMap<Integer,Boolean> primeMap = sieveHashMap(sieve_limit);

      sieveHashMapPrinter(primeMap);
      
    }

    catch(NumberFormatException nfe){
      System.out.println("\n\tInput must be an integer! Error : " + nfe.getMessage() + "\n");
    }

  }
}
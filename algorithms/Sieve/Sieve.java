import java.util.HashMap;

public class Sieve{



    public static void main(String[] args){
        
        // allows user to input the size of the sieve
        int n;
        
        n = args.length < 1 ? 100
                            : Integer.valueOf(args[0]);
                            
        
        HashMap<Integer, Boolean> map = new HashMap<>(n);


        System.out.println(map);
        System.out.println(n);
        System.out.println(map.size());
        



    }
}
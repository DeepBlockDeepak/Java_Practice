package java8lambdabasicsunit2;

/*
TODO Check out video 20 for the final ideas here
 */


public class ThisReferenceExample {
    // Process from ClosuresExample.java
    public void doProcess(int i, Process p){
        p.process(i);
    }

    public static void main(String[] args) {

        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

        /* TODO: left off here, don't know what the plan was. */
        thisReferenceExample.doProcess(5, p -> System.out.println(p));

        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.printf("Value of i is %d\n", i);
                System.out.println(this);
            }

            public String toString(){
                return "This is the anonymous inner class";
            }
        });


    }

}

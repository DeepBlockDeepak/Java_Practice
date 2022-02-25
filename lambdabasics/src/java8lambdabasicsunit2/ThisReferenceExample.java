package java8lambdabasicsunit2;

public class ThisReferenceExample {
    // Process from ClosuresExample.java
    public void doProcess(int i, Process p){
        p.process(i);
    }

    public static void main(String[] args) {

        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

        thisReferenceExample.doProcess();


    }

}

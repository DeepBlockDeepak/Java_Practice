package java8lambdabasicsunit2;

public class ClosuresExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        /* Using anonymous inner class */
        doProcess(a, new Process(){

            @Override
            public void process(int i) {
                System.out.println(i + b);
            }
        });

        /* Using Lambda */
        doProcess(a, p -> System.out.println(p + b));

    }

    public static void doProcess(int i, Process p){
        p.process(i);
    }

}



interface Process {
    void process(int i);
}

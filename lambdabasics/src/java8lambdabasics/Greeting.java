package java8lambdabasics;

// lets other developers know that this interface is functional,
// and shouldn't, else dependent code will break
@FunctionalInterface
public interface Greeting {
    public void perform();
}

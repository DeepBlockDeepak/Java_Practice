package java8lambdabasics;

// lets other developers know that this interface is functional, made for lambdas,
// and the signature shouldn't be modified, else dependent code will break
@FunctionalInterface
public interface Greeting {
    public void perform();
}

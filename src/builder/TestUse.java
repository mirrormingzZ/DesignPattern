package builder;

public class TestUse {
    public static void main(String args[]) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
    }
}
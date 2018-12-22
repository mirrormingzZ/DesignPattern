package bridge;

/**
 * @program: DesignPattern
 * @description: Test
 * @author: mirrorming
 * @create: 2018-07-08 18:22
 **/

public class TestUse {
    public static void main(String[] args) {
        Computer computer = new Laptop(new Apple());
        computer.sale();

        Computer computer2 = new Laptop(new Xiaomi());
        computer2.sale();
    }
}
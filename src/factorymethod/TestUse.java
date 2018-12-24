package factorymethod;

public class TestUse {
    public static void main(String args[]) {
        Car car1 = new BenzFactory().createCar();
        Car car2 = new PorscheFactory().createCar();

        car1.run();
        car2.run();
    }
}
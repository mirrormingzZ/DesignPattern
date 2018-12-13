package decorator;

public class TestUse {
    public static void main(String args[]) {
        ICar iCar = new Car();
        iCar.move();

        System.out.println("----------------增加新的功能----------------");
        FlyCar flyCar = new FlyCar(iCar);
        flyCar.move();

        System.out.println("----------------增加新的功能----------------");
        WaterCar waterCar = new WaterCar(iCar);
        waterCar.move();
    }
}
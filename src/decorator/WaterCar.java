package decorator;

/**
 * @program: DesignPattern
 * @description: ConcreteDecorator具体装饰角色
 * @author: mirrorming
 * @create: 2018-07-13 15:43
 **/

public class WaterCar extends SuperCar {
    public WaterCar(ICar car) {
        super(car);
    }

    @Override
    public void move() {
        super.move();
        swim();
    }

    private void swim() {
        System.out.println("swim_car");
    }
}
package decorator;

/**
 * @program: JavaPractice
 * @description: ConcreteDecorator具体装饰角色
 * @author: mirrorming
 * @create: 2018-07-05 15:26
 **/

public class FlyCar extends SuperCar {
    public FlyCar(ICar car) {
        super(car);
    }

    @Override
    public void move() {
        super.move();
        fly();
    }

    private void fly() {
        System.out.println("fly_car");
    }
}
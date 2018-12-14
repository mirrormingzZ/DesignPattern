package decorator;

/**
 * @program: JavaPractice
 * @description: Decorator装饰角色
 * @author: mirrorming
 * @create: 2018-07-05 15:23
 **/

public class SuperCar implements ICar {

    protected ICar car;

    public SuperCar(ICar car) {
        super();
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}
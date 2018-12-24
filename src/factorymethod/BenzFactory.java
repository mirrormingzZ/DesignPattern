package factorymethod;

/**
 * @program: DesignPattern
 * @description: 奔驰工厂类
 * @author: mirrorming
 * @create: 2018-07-10 19:15
 **/

public class BenzFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Benz();
    }
}
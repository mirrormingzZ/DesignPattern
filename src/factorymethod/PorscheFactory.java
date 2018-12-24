package factorymethod;

/**
 * @program: DesignPattern
 * @description: 保时捷工厂
 * @author: mirrorming
 * @create: 2018-07-10 19:27
 **/

public class PorscheFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Porsche();
    }
}
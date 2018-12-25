package abstractfactory;


/**
 * @program: DesignPattern
 * @description: 低端汽车工厂
 * @author: mirrorming
 * @create: 2018-07-11 08:47
 **/

public class LowCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }
}
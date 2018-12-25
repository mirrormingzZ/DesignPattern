package abstractfactory;

/**
 * @program: DesignPattern
 * @description: 高端汽车工厂
 * @author: mirrorming
 * @create: 2018-07-11 08:46
 **/

public class LuxuryCarFactory implements CarFactory {

    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }
}
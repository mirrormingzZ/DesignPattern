package abstractfactory;

/**
 * @program: DesignPattern
 * @description: 汽车工厂
 * @author: mirrorming
 * @create: 2018-07-11 08:44
 **/

public interface CarFactory {
    Engine createEngine();

    Tyre createTyre();
}
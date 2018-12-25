package abstractfactory;

/**
 * @program: DesignPattern
 * @description: 汽车工厂
 * @author: mirrorming
 * @create: 2018-12-25 08:44
 **/

public interface CarFactory {
    Engine createEngine();

    Tyre createTyre();
}
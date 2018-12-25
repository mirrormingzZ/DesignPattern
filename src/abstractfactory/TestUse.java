package abstractfactory;

/**
 * @program: DesignPattern
 * @description: 测试类
 * @author: mirrorming
 * @create: 2018-07-11 08:48
 **/

public class TestUse {
    public static void main(String[] args) {
        CarFactory carFactory = new LuxuryCarFactory();
        Engine engine = carFactory.createEngine();
        Tyre tyre = carFactory.createTyre();
        engine.run();
        tyre.wear();
        System.out.println("==================================================");
        CarFactory carFactory2 = new LowCarFactory();
        Engine engine2 = carFactory2.createEngine();
        Tyre tyre2 = carFactory2.createTyre();
        engine2.run();
        tyre2.wear();
    }
}
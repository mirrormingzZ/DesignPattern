package simplefactory;


/**
 * @program: DesignPattern
 * @description: 简单工厂
 * @author: mirrorming
 * @create: 2018-07-09 16:56
 **/

public class PhoneFactory {
    public static Phone creatCar(String type) {
        if ("诺基亚".equals(type)) {
            return new NuoJiYa();
        } else if ("苹果".equals(type)) {
            return new Iphone();
        } else {
            return null;
        }
    }
}

interface Phone {
    void call();
}

class NuoJiYa implements Phone {

    @Override
    public void call() {
        System.out.println("挪鸡鸭手机");
    }
}

class Iphone implements Phone {

    @Override
    public void call() {
        System.out.println("水果手机");
    }
}
package simplefactory;

/**
 * @program: DesignPattern
 * @description: 测试类
 * @author: mirrorming
 * @create: 2018-07-09 17:04
 **/

public class TestUse {
    public static void main(String[] args) {
        Phone phone1 = PhoneFactory.creatCar("诺基亚");
        Phone phone2 = PhoneFactory.creatCar("苹果");
        phone1.call();
        phone2.call();
    }
}
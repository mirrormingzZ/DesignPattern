package bridge;

/**
 * @program: DesignPattern
 * @description: 品牌
 * @author: mirrorming
 * @create: 2018-07-08 18:09
 **/

public interface Brand {
    void sale();
}

class Apple implements Brand {

    @Override
    public void sale() {
        System.out.println("销售苹果");
    }
}

class Xiaomi implements Brand {

    @Override
    public void sale() {
        System.out.println("销售小米");
    }
}
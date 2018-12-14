package builder;

/**
 * @program: JavaPractice
 * @description: 抽象builder类
 * @author: mirrorming
 * @create: 2018-07-04 16:16
 **/

abstract class Builder {
    //返回产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getProduct() {
        return product;
    }
}
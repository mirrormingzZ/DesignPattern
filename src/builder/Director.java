package builder;

/**
 * @program: JavaPractice
 * @description: 指挥类
 * @author: mirrorming
 * @create: 2018-07-04 16:26
 **/

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    /**
     * @Description: 产品构建与组装方法
     * @Param: []
     * @return: Product
     * @Author: mirrorming
     * @Date: 2018/07/04
     */
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getProduct();
    }
}

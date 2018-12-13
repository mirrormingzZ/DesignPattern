package builder;

/**
 * @program: JavaPractice
 * @description: 具体构建类
 * @author: mirrorming
 * @create: 2018-07-12 16:21
 **/

public class ConcreteBuilder extends Builder {

    @Override
    public void buildPartA() {
        System.out.println("f_buildPartA");
    }

    @Override
    public void buildPartB() {
        System.out.println("f_buildPartB");
    }

    @Override
    public void buildPartC() {
        System.out.println("f_buildPartC");
    }
}
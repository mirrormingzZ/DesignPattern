package decorator;

/**
 * @program: JavaPractice
 * @description: ConcreteComponent具体构件角色(真实对象)
 * @author: mirrorming
 * @create: 2018-07-13 15:22
 **/

public class Car implements ICar {
    @Override
    public void move() {
        System.out.println("Car_move");
    }
}
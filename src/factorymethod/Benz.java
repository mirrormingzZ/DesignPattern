package factorymethod;

/**
 * @program: DesignPattern
 * @description: 奔驰
 * @author: mirrorming
 * @create: 2018-07-10 19:14
 **/

public class Benz implements Car {
    @Override
    public void run() {
        System.out.println("梅赛德斯-奔驰");
    }
}
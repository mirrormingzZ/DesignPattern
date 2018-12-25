package abstractfactory;

/**
 * @program: DesignPattern
 * @description: 轮胎
 * @author: mirrorming
 * @create: 2018-07-11 08:40
 **/

public interface Tyre {
    void wear();
}

class LuxuryTyre implements Tyre {
    @Override
    public void wear() {
        System.out.println("高端轮胎!");
    }
}

class LowTyre implements Tyre {
    @Override
    public void wear() {
        System.out.println("低端轮胎!");
    }
}
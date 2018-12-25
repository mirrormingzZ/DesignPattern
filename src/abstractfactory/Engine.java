package abstractfactory;

/**
 * @program: DesignPattern
 * @description: 引擎
 * @author: mirrorming
 * @create: 2018-12-25 08:37
 **/

public interface Engine {
    void run();
}

class LuxuryEngine implements Engine {

    @Override
    public void run() {
        System.out.println("高端引擎!");
    }
}

class LowEngine implements Engine {

    @Override
    public void run() {
        System.out.println("低端引擎!");
    }
}
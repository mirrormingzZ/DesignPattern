package facade;

/**
 * @program: DesignPattern
 * @description: 外观
 * @author: mirrorming
 * @create: 2018-07-06 18:56
 **/

public class Facade {
    private ModelA modelA = null;
    private ModelB modelB = null;

    private static Facade facade = null;

    private Facade() {
        modelA = new ModelA();
        modelB = new ModelB();
    }

    public static Facade getInstance() {
        if (facade == null) {
            facade = new Facade();
        }
        return facade;
    }

    public void fFacade() {
        modelA.fA();
        modelB.fB();
    }
}
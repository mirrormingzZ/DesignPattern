package adapter;

/**
 * 对象适配器
 */
public class ObjectAdapter implements Target {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void fInAdaptee(Object obj) {
        adaptee.fInAdaptee("对象适配器传的参数");
        System.out.println("对象适配器的fInAdaptee:" + obj);
    }

    @Override
    public void fOther(Object obj) {
        System.out.println("对象适配器的fOther:" + obj);
    }
}
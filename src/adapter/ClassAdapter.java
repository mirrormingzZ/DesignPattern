package adapter;

/**
 * 类适配器
 */
public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void fInAdaptee(Object obj) {
        System.out.println("fInAdaptee_新增的方法:" + obj);
    }

    @Override
    public void fOther(Object obj) {
        System.out.println("其他的方法:" + obj);
    }
}
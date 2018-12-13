package adapter;

public class TestUse {
    public static void main(String args[]) {
        Adaptee adaptee = new Adaptee();
//        adaptee.fInAdaptee("test_f_Adaptee");
//        Target target = new ClassAdapter();
//        target.fOther("test_f_other");
//        target.fInAdaptee("test_f_Adaptee_2");
        Target target = new ObjectAdapter(adaptee);
        target.fOther("test_f_other");
        target.fInAdaptee("test_f_Adaptee_2");
    }
}
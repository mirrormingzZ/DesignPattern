package adapter;

/**
 * 被适配者
 */
class Adaptee {
    void fInAdaptee(Object obj) {
        System.out.println("被适配者的方法：" + obj);
    }
}
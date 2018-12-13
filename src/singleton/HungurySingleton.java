package singleton;

public class HungurySingleton {
    // 创建 SingleObject 的一个对象
    private static final HungurySingleton hungurySingletonInstance = new HungurySingleton();

    // 让构造函数为 private，这样该类就不会被实例化
    private HungurySingleton() {
        System.out.println("HungurySingleton被创建了!");
    }

    // 获取唯一可用的对象
    public static HungurySingleton getHungurySingleton() {
        return hungurySingletonInstance;
    }

    public static void showMessage() {
        System.out.println("showMessage in HungurySingleton!");
    }

    public static void main(String[] args) {
        HungurySingleton.showMessage();
    }
}

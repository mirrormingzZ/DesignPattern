package singleton;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("LazySingleton被创建了!");
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void showMessage() {
        System.out.println("showMessage in LazySingleton!");
    }

    public static void main(String[] args) {
        LazySingleton.showMessage();
    }
}

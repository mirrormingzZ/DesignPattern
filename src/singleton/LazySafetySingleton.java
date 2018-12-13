package singleton;

public class LazySafetySingleton {
    private static LazySafetySingleton instance;

    private LazySafetySingleton() {
        System.out.println("LazySafetySingleton被创建了!");
    }

    public synchronized static LazySafetySingleton getInstance_1() {
        if (instance == null) {
            instance = new LazySafetySingleton();
        }
        return instance;
    }

    public static LazySafetySingleton getInstance_2() {
        synchronized (LazySafetySingleton.class) {
            if (instance == null) {
                instance = new LazySafetySingleton();
            }
        }
        return instance;
    }

    public static void showMessage() {
        System.out.println("showMessage in LazySafetySingleton!");
    }

    public static void main(String[] args) {
        LazySafetySingleton.showMessage();
    }
}

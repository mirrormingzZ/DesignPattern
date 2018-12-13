package singleton;

public class DclSingleton {
    private static volatile DclSingleton instance = null;

    private DclSingleton() {
        System.out.println("DclSingleton被创建了!");
    }

    public static DclSingleton getInstance() {
        if (instance == null) {
            synchronized (DclSingleton.class) {
                if (instance == null) {
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }

    public static void showMessage() {
        System.out.println("showMessage in DclSingleton!");
    }

    public static void main(String[] args) {
        DclSingleton.showMessage();
    }
}

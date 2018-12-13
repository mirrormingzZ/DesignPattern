package singleton;

public class StaticInnerSingleton {
    private static StaticInnerSingleton instance;

    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static final StaticInnerSingleton sInstance = new StaticInnerSingleton();
    }
}

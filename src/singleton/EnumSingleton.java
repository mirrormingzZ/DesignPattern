package singleton;

/**
 * 枚举实现单例模式，可以用于多线程
 */
public enum EnumSingleton {
    instance;

    public void doSomeThing() {
        System.out.println("f_doSomeThing");
    }
}

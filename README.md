## 单例模式

#### 概念

> 单例模式是一种对象创建模式 , 它用于产生一个对象的具体实例 , 它可以确保系统中一个类只产生一个实例

#### 好处

> 1. 对于频繁使用的对象 , 可以省略创建对象所花费的时间 , 这对于那些重量级的对象而言 , 是非常可观的一笔系统开销
> 2. 由于new操作的次数减少 , 因而对系统内存的使用频率也会降低 , 这将减轻GC的压力 , 缩短GC停顿时间

####单例之饿汉

> 不足: 无法对instance实例延时加载

```java
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
```

*输出*

```java
HungurySingleton被创建了!
showMessage in HungurySingleton!
```

#### 单例之懒汉

> 不足: 多线程并发下这样的实现是无法保证实例唯一的

```java
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
```

*输出*

```java
showMessage in LazySingleton!
```

#### 单例之懒汉线程安全版

> 不足: 性能不好

```java
package singleton;

public class LazySafetySingleton {
    private static LazySafetySingleton instance;

    private LazySafetySingleton() {
        System.out.println("LazySingleton被创建了!");
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
        System.out.println("showMessage in LazySingleton!");
    }

    public static void main(String[] args) {
        LazySafetySingleton.showMessage();
    }
}
```

#### 单例之DCL

> 不足: JVM的即时编译器中存在指令重排序优化

```java
package singleton;

public class DclSingleton {
    private static DclSingleton instance = null;

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
```

**双重校验锁缺陷:**

`instance = new DclSingleton();`不是一个原子操作 , 而是三步

1. 给`instance`分配内存
2. 调用`DclSingleton`的构造方法来初始化变量
3. 将`instance`对象指向`JVM`分配的内存空间

由于`JVM`即时编译器存在指令重排序优化 , 往往这三步并不是按照顺序执行的

**解决办法:**

给`private static DclSingleton instance = null;`加上`volatile`关键字.

`volatile`能保证线程在本地不会存有`instance`的副本 , 可以禁止`JVM`的指令重排序

#### 单例之静态内部类

> 利用`JVM`本身机制保证线程安全 , 没有性能缺陷
>
> `static`和`final`

```java
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
```

 #### 单例之枚举

> JDK5之后才能使用

```java
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
```



## build模式

### 概念

> 建造者模式是较为复杂的创建型模式 , 它将客户端与包含多个组成部分(或部件)的复杂对象的创建过程分离

#### 使用场景

> 当构造一个对象需要很多参数的时候 , 并且参数的个数或者类型不固定的时候

#### 代码

**Builder:**

```java
package builder;

import facade.ProductPrice;

/**
 * @program: JavaPractice
 * @description: 抽象builder类
 * @author: mirrorming
 * @create: 2018-07-12 16:16
 **/

abstract class Builder {
    //返回产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getProduct() {
        return product;
    }
}
```

**ConcreteBuilder:**

```java
package builder;

/**
 * @program: JavaPractice
 * @description: 具体构建类
 * @author: mirrorming
 * @create: 2018-07-12 16:21
 **/

public class ConcreteBuilder extends Builder {

    @Override
    public void buildPartA() {
        System.out.println("f_buildPartA");
    }

    @Override
    public void buildPartB() {
        System.out.println("f_buildPartB");
    }

    @Override
    public void buildPartC() {
        System.out.println("f_buildPartC");
    }
}
```

**Director:**

```java
package builder;

/**
 * @program: JavaPractice
 * @description: 指挥类
 * @author: mirrorming
 * @create: 2018-07-12 16:26
 **/

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    /**
     * @Description: 产品构建与组装方法
     * @Param: []
     * @return: Product
     * @Author: mirrorming
     * @Date: 2018/07/12
     */
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getProduct();
    }
}

```

**Product:**

```java
package builder;

/**
 * @program: JavaPractice
 * @description:
 * @author: mirrorming
 * @create: 2018-07-12 16:16
 **/

public class Product {
    private String partA;
    private String partB;
    private String partC;


    public String getPartA() {
        return partA;
    }

    public String getPartB() {
        return partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }
}
```

**测试类和输出:**

```java
package builder;

public class TestUse {
    public static void main(String args[]) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
    }
}
```

#### 总结

- Builder: 它为创建一个产品Product对象的各个部件指定抽象接口
- ConcreteBuilder: 它实现了Builder接口 , 实现各个部件的具体构造和装配方法
- Product: 它是被构建的复杂对象 , 包含多个组成部件
- Director: 指挥者又称为导演类 , 它负责安排复杂对象的建造次序 , 指挥者与抽象建造者之间存在关联关系

#### 优点

- 松散耦合: 生成器模式可以用同一个构建算法构建出表现上完全不同的产品 , 实现产品构建和产品表现上的分离
- 可以很容易的改变产品的内部表示
- 更好的复用性: 生成器模式很好的实现构造算法和具体产品实现的分离

#### 缺点

- 会产生多余的Builder对象以及Director对象 , 消耗内存
- 对象的构建过程暴露



##adapter模式

###适配器模式定义

> 将一个接口转换成客户希望的另一个接口 , 适配器模式使接口不兼容的那些类可以一起工作 , 其别名为包装器(Wrapper)

### 类适配器

#### 定义

> 类的适配器模式把适配的类的API转换成为目标类的API

#### 代码

**Adaptee被适配者**

```java
package adapter;

//被适配者
class Adaptee {
    void fInAdaptee(Object obj) {
        System.out.println("被适配者的方法：" + obj);
    }
}
```

**ClassAdapter类适配器**

```java
package adapter;

//类适配器
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
```

**Target接口**

```java
package adapter;

interface Target {
    void fInAdaptee(Object src);
    void fOther(Object src);
}
```

**测试方法和输出**

```java
package adapter;

public class TestUse {
    public static void main(String args[]) {
        Adaptee adaptee = new Adaptee();
        adaptee.fInAdaptee("test_f_Adaptee");
        Target target = new ClassAdapter();
        target.fOther("test_f_other");
        target.fInAdaptee("test_f_Adaptee_2");
    }
}


被适配者的方法：test_f_Adaptee
其他的方法:test_f_other
fInAdaptee_新增的方法:test_f_Adaptee_2
```



#### 总结

- 类适配器使用对象继承的方式 , 是静态的定义方式
- 对于类适配器 , 适配器可以重定义`Adaptee(适配者)`的部分行为
- 对于类适配器 , 仅仅引入了一个对象 , 并不需要额外的引用来间接得到`Adaptee`
- 对于类适配器 , 由于适配器直接继承了`Adaptee` , 使得适配器不能和`Adaptee`的子类一起工作

### 对象适配器

#### 定义

> 与类适配器模式一样 , 对象的适配器模式把被适配的类的`API`转换成为目标类的`API`  , 与类的适配器模式不同的是 , 对象的适配器模式不是使用继承关系连接到`Adaptee`类(适配者) , 而是使用委派关系连接到`Adaptee`类

#### 代码

**ObjectAdapter对象适配器**

```java
package adapter;

//对象适配器
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
```

**测试类和输出**

```java
package adapter;

public class TestUse {
    public static void main(String args[]) {
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.fOther("test_f_other");
        target.fInAdaptee("test_f_Adaptee_2");

    }
}


对象适配器的fOther:test_f_other
被适配者的方法：对象适配器传的参数
对象适配器的fInAdaptee:test_f_Adaptee_2
```



####总结

- 对象适配器使用对象组合的方式 , 是动态组合的方式
- 对于对象适配器 , 一个适配器可以把多种不同的源适配到同一个目标
- 对于对象适配器 , 要重定义`Adaptee`的行为比较困难
- 对于对象适配器 , 需要额外的引用来间接得到`Adaptee`



## 装饰模式

### 概念

装饰模式(Decorator Pattern): 动态地给一个对象增加一些额外的职责 , 就增加对象功能来说 , 装饰模式比生成子类实现更为灵活 . 装饰模式是一种对象结构型模式 .

### 使用场景

- 在不影响其他对象的情况下 , 以动态透明的方式给单个对象添加职责
- 当不能采用继承的方式对系统进行扩展或者采用继承不利于系统扩展和维护时可以使用装饰模式

### 实现细节

- Component抽象构件角色
  - 真实对象和装饰对象有相同的接口 , 这样 , 客户端对象就能够以与真实对象相同的方式同装饰对象交互
- ConcreteComponent具体构件角色(真实对象)
  - IO流中的FileInputStream , FileOutputStream
- Decorator装饰角色
  - 持有一个对象构件的引用 , 装饰对象接受所有客户端的请求 , 并把这些请求转发给真实的对象
- ConcreteDecorator具体装饰角色
  - 负责给构件对象增加新的责任

### 代码

```java
package decorator;

/**
 * @program: JavaPractice
 * @description: 抽象组件
 * @author: mirrorming
 * @create: 2018-07-13 15:19
 **/

public interface ICar {
    void move();
}
```

```java
package decorator;

/**
 * @program: JavaPractice
 * @description: ConcreteComponent具体构件角色(真实对象)
 * @author: mirrorming
 * @create: 2018-07-13 15:22
 **/

public class Car implements ICar {
    @Override
    public void move() {
        System.out.println("Car_move");
    }
}
```

```java
package decorator;

/**
 * @program: JavaPractice
 * @description: Decorator装饰角色
 * @author: mirrorming
 * @create: 2018-07-13 15:23
 **/

public class SuperCar implements ICar {

    protected ICar car;

    public SuperCar(ICar car) {
        super();
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}
```

```java
package decorator;

/**
 * @program: JavaPractice
 * @description: ConcreteDecorator具体装饰角色
 * @author: mirrorming
 * @create: 2018-07-13 15:26
 **/

public class FlyCar extends SuperCar {
    public FlyCar(ICar car) {
        super(car);
    }

    @Override
    public void move() {
        super.move();
        fly();
    }

    private void fly() {
        System.out.println("fly_car");
    }
}
```

```java
package decorator;

public class TestUse {
    public static void main(String args[]) {
        ICar iCar = new Car();
        iCar.move();

        System.out.println("----------------增加新的功能----------------");
        FlyCar flyCar = new FlyCar(iCar);
        flyCar.move();

        System.out.println("----------------增加新的功能----------------");
        WaterCar waterCar = new WaterCar(iCar);
        waterCar.move();
    }
}



Car_move
----------------增加新的功能----------------
Car_move
fly_car
----------------增加新的功能----------------
Car_move
swim_car
```



### 优点

- 对于扩展一个对象的功能 , 装饰模式比继承更加灵活性 , 不会导致类的个数急剧增加
- 可以通过一种动态的方式来扩展一个对象的功能
- 可以对一个对象进行多次装饰 , 通过使用不同的具体装饰类以及这些装饰类的排列组合

## 外观模式

### 概念

> 外观模式的主要目的在于让外部减少与子系统内部多个模块的交互 , 从而让外部能够更简单得使用子系统 . 它负责把客户端的请求转发给子系统内部的各个模块进行处理

### 使用场景

- 当你要为一个复杂子系统提供一个简单接口时
- 客户程序与抽象类的实现部分之间存在着很大的依赖性
- 当你需要构建一个层次结构的子系统时

 ### 代码

```java
package facade;

/**
 * @program: DesignPattern
 * @description: 模块A
 * @author: mirrorming
 * @create: 2018-07-06 18:53
 **/
public class ModelA {
    public void fA() {
        System.out.println("f_ModelA");
    }
}

package facade;

/**
 * @program: DesignPattern
 * @description: 模块B
 * @author: mirrorming
 * @create: 2018-07-06 18:55
 **/
public class ModelB {
    public void fB() {
        System.out.println("f_ModelB");
    }
}
```

```java
package facade;

/**
 * @program: DesignPattern
 * @description: 外观
 * @author: mirrorming
 * @create: 2018-07-06 18:56
 **/
public class Facade {
    private ModelA modelA = null;
    private ModelB modelB = null;

    private static Facade facade = null;

    private Facade() {
        modelA = new ModelA();
        modelB = new ModelB();
    }

    public static Facade getInstance() {
        if (facade == null) {
            facade = new Facade();
        }
        return facade;
    }

    public void fFacade() {
        modelA.fA();
        modelB.fB();
    }
}
```

```java
package facade;

public class TestUse {
    public static void main(String args[]) {
        Facade facade = Facade.getInstance();
        facade.fFacade();
    }
}
```

### 优点

- 由于Facade类封装了各个模块交互的过程 , 如果今后内部模块调用关系发生了变化 , 只需要修改Facade实现就可以了
- Facade实现是可以被多个客户端调用的

## 组合模式

###概念

>  组合多个对象形成树形结构以表示具有“整体—部分”关系的层次结构。组合模式对单个对象（即叶子对象）和组合对象（即容器对象）的使用具有一致性，组合模式又可以称为“整体—部分”(Part-Whole)模式，它是一种对象结构型模式。

### 使用场景

- 把部分和整体的关系用树形结构表示 , 从而使客户端可以使用统一的方式处理部分对象和整体对象

### 实现细节

- **抽象构件(Component)角色:** 它可以是接口或抽象类，为叶子构件和容器构件对象声明接口，在该角色中可以包含所有子类共有行为的声明和实现。在抽象构件中定义了访问及管理它的子构件的方法，如增加子构件、删除子构件、获取子构件等。
- **叶子(Leaf)构件角色:** 它在组合结构中表示叶子节点对象，叶子节点没有子节点，它实现了在抽象构件中定义的行为。对于那些访问及管理子构件的方法，可以通过异常等方式进行处理。
- **容器(Composite)构件角色:** 它在组合结构中表示容器节点对象，容器节点包含子节点，其子节点可以是叶子节点，也可以是容器节点，它提供一个集合用于存储子节点，实现了在抽象构件中定义的行为，包括那些访问及管理子构件的方法，在其业务方法中可以递归调用其子节点的业务方法。

 ### 代码

```java
package Composite;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: DesignPattern
 * @description: 抽象构件
 * @author: mirrorming
 * @create: 2018-07-06 15:39
 **/

public interface AbstractFile {
    void killVirus();//杀毒
}

class ImageFile implements AbstractFile {

    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("查杀图片文件:" + name);
    }
}

class VideoFile implements AbstractFile {

    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("查杀视频文件:" + name);
    }
}

class Folder implements AbstractFile {

    private String name;
    private List<AbstractFile> list = new ArrayList<AbstractFile>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        list.add(file);
    }

    public void remove(AbstractFile file) {
        list.remove(file);
    }

    public AbstractFile getChild(int index) {
        return list.get(index);
    }

    @Override
    public void killVirus() {
        System.out.println("文件夹查杀:" + name);
        for (AbstractFile file : list) {
            file.killVirus();
        }
    }
}
```

```java
package Composite;

/**
 * @program: DesignPattern
 * @description: 测试
 * @author: mirrorming
 * @create: 2018-07-06 15:53
 **/

public class TestUse {
    public static void main(String[] args) {
        AbstractFile a, b, c, d, e;
        a = new Folder("我的文件夹");
        b = new ImageFile("图片文件");
        c = new VideoFile("视频文件");
        d = new Folder("另一个文件夹");
        e = new VideoFile("视频文件2");
        ((Folder) a).add(b);
        ((Folder) a).add(c);
        ((Folder) d).add(e);
        ((Folder) a).add(d);
        a.killVirus();
    }
}
```

### 优点

- 可以清楚地定义分层次的复杂对象，表示对象的全部或部分层次，使得增加新构件也更容易。
- 客户端调用简单，客户端可以一致的使用组合结构或其中单个对象。
- 定义了包含叶子对象和容器对象的类层次结构，叶子对象可以被组合成更复杂的容器对象，而这个容器对象又可以被组合，这样不断递归下去，可以形成复杂的树形结构。
- 更容易在组合体内加入对象构件，客户端不必因为加入了新的对象构件而更改原有代码。

###缺点
- 使设计变得更加抽象，对象的业务规则如果很复杂，则实现组合模式具有很大挑战性，而且不是所有的方法都与叶子对象子类都有关联。
- 增加新构件时可能会产生一些问题，很难对容器中的构件类型进行限制

## 桥接模式

### 概念

> 桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。这种类型的设计模式属于结构型模式，它通过提供抽象化和实现化之间的桥接结构，来实现二者的解耦。

### 使用场景

- 如果一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性，避免在两个层次之间建立静态的继承联系，通过桥接模式可以使它们在抽象层建立一个关联关系
- 对于那些不希望使用继承或因为多层次继承导致系统类的个数急剧增加的系统，桥接模式尤为适用
- 一个类存在两个独立变化的维度，且这两个维度都需要进行扩展。

###实现细节

- **Implementor**，实现类接口。
- **ConcreteImplementor**，具体实现类。
- **Abstraction**，抽象类。
- **RefinedAbstraction**，扩充抽象类。

### 代码

```java
package bridge;

/**
 * @program: DesignPattern
 * @description: 品牌
 * @author: mirrorming
 * @create: 2018-07-08 18:09
 **/

public interface Brand {
    void sale();
}

class Apple implements Brand {

    @Override
    public void sale() {
        System.out.println("销售苹果");
    }
}

class Xiaomi implements Brand {

    @Override
    public void sale() {
        System.out.println("销售小米");
    }
}
```

```java
package bridge;

/**
 * @program: DesignPattern
 * @description: 手机
 * @author: mirrorming
 * @create: 2018-07-08 18:14
 **/

public class Computer {
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void sale() {
        brand.sale();
        System.out.println("销售电脑");
    }
}

class Desktop extends Computer {

    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式机");
    }
}

class Laptop extends Computer {

    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售笔记本");
    }
}
```

```java
package bridge;

/**
 * @program: DesignPattern
 * @description: Test
 * @author: mirrorming
 * @create: 2018-07-08 18:22
 **/

public class TestUse {
    public static void main(String[] args) {
        Computer computer = new Laptop(new Apple());
        computer.sale();

        Computer computer2 = new Laptop(new Xiaomi());
        computer2.sale();
    }
}
```

### 优点

- 抽象和实现的分离
- 优秀的扩展能力
- 实现细节对客户透明

### 缺点

- 桥接模式的引入会增加系统的理解与设计难度，由于聚合关联关系建立在抽象层，要求开发者针对抽象进行设计与编程。
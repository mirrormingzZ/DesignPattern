package Composite;

/**
 * @program: DesignPattern
 * @description: 抽象构件
 * @author: mirrorming
 * @create: 2018-07-06 15:35
 **/

public interface Component {
    void operation();
}

interface Leaf extends Component {

}

interface Composite extends Component {
    void add(Component component);

    void remove(Component component);

    void getChild(int index);
}
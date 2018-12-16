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
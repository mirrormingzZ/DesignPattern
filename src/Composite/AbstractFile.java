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
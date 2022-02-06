package singletone.design.pattern;

public class SingletonObject {
    public static SingletonObject obj = new SingletonObject();

    private SingletonObject() {

    }

    public static SingletonObject getInstance() {
        return obj;
    }
}

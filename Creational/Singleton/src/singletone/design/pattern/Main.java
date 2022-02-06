package singletone.design.pattern;

public class Main {
    public static void main(String[] args) {
        SingletonObject firstSingletonObject = SingletonObject.getInstance();

        SingletonObject secondSingletonObject = SingletonObject.getInstance();

        System.out.println(firstSingletonObject.hashCode() == secondSingletonObject.hashCode());
    }
}

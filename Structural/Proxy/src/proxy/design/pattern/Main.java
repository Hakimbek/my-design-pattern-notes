package proxy.design.pattern;

public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("myImage.png");

        //image will be loaded from disk
        image.display();

        //image will not be loaded from disk
        image.display();
    }
}

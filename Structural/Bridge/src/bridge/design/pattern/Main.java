package bridge.design.pattern;

public class Main {
    public static void main(String[] args) {
        Circle redCircle = new Circle(new RedCircle(), 10, 5, 6);
        Circle greenCircle = new Circle(new GreenCircle(), 10, 5, 6);

        redCircle.draw();
        greenCircle.draw();
    }
}

package abstractFactory.design.pattern;

public class Main {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = FactoryProducer.getFactory(false);

        Shape square = abstractFactory.getShape("square");
        square.draw();

        Shape rectangle = abstractFactory.getShape("rectangle");
        rectangle.draw();

        AbstractFactory roundedAbstractFactory = FactoryProducer.getFactory(true);

        Shape roundedSquare = roundedAbstractFactory.getShape("square");
        roundedSquare.draw();

        Shape roundedRectangle = roundedAbstractFactory.getShape("rectangle");
        roundedRectangle.draw();
    }
}

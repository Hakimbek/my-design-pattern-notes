package abstractFactory.design.pattern;

public class ShapeFactory extends AbstractFactory {

    @Override
    Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        }

        return null;
    }

}

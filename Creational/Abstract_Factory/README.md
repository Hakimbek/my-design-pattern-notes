# Abstract Factory Pattern
Abstract Factory Pattern says that just define an interface or abstract class for creating families of related (or dependent) objects but without specifying their concrete sub-classes.That means Abstract Factory lets a class returns a factory of classes. So, this is the reason that Abstract Factory Pattern is one level higher than the Factory Pattern.

An Abstract Factory Pattern is also known as **Kit**.

## Example of Abstract Factory Pattern

## Step 1: Create an interface for Shapes.

### Shape.java

```java
public interface Shape {
   void draw();
}
```


## Step 2: Create concrete classes implementing the same interface.

### RoundedRectangle.java

```java
public class RoundedRectangle implements Shape {
   @Override
   public void draw() {
      System.out.println("Inside RoundedRectangle::draw() method.");
   }
}
```

### RoundedSquare.java

```java
public class RoundedSquare implements Shape {
   @Override
   public void draw() {
      System.out.println("Inside RoundedSquare::draw() method.");
   }
}
```

### Rectangle.java

```java
public class Rectangle implements Shape {
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}
```

### Square.java

```java
public class Square implements Shape {
   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}
```

## Step 3: Create an Abstract class to get factories for Normal and Rounded Shape Objects.

### AbstractFactory.java

```java
public abstract class AbstractFactory {
   abstract Shape getShape(String shapeType) ;
}
```

## Step 4: Create Factory classes extending AbstractFactory to generate object of concrete class based on given information.

### ShapeFactory.java

```java
public class ShapeFactory extends AbstractFactory {
   @Override
   public Shape getShape(String shapeType){    
      if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();         
      }else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }	 
      return null;
   }
}
```

### RoundedShapeFactory.java

```java
public class RoundedShapeFactory extends AbstractFactory {
   @Override
   public Shape getShape(String shapeType){    
      if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new RoundedRectangle();         
      }else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new RoundedSquare();
      }	 
      return null;
   }
}
```

## Step 5: Create a Factory generator/producer class to get factories by passing an information such as Shape

### FactoryProducer.java

```java
public class FactoryProducer {
   public static AbstractFactory getFactory(boolean rounded) {   
      if (rounded) {
         return new RoundedShapeFactory();         
      } else {
         return new ShapeFactory();
      }
   }
}
```

## Step 6: Use the FactoryProducer to get AbstractFactory in order to get factories of concrete classes by passing an information such as type.

### AbstractFactoryPatternDemo.java

```java
public class AbstractFactoryPatternDemo {
   public static void main(String[] args) {
      //get shape factory
      AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
      //get an object of Shape Rectangle
      Shape rectangle = shapeFactory.getShape("RECTANGLE");
      //call draw method of Shape Rectangle
      rectangle.draw();
      //get an object of Shape Square 
      Shape square = shapeFactory.getShape("SQUARE");
      //call draw method of Shape Square
      square.draw();
      
      //get shape factory
      AbstractFactory roundedShapeFactory = FactoryProducer.getFactory(true);
      //get an object of Shape Rectangle
      Shape roundedRectangle = roundedShapeFactory.getShape("RECTANGLE");
      //call draw method of Shape Rectangle
      roundedRectangle.draw();
      //get an object of Shape Square 
      Shape roundeedSquare = roundedShapeFactory.getShape("SQUARE");
      //call draw method of Shape Square
      roundeedSquare.draw();
      
   }
}
```

### Output:

```
Inside Rectangle::draw() method.
Inside Square::draw() method.
Inside RoundedRectangle::draw() method.
Inside RoundedSquare::draw() method.
```

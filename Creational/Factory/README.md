# Factory Method Pattern
A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of the class.

The Factory Method Pattern is also known as **Virtual Constructor**.

## Example of Factory Method

## Step 1: Create an interface.

### Shape.java

```java
public interface Shape {
   void draw();
}
```


## Step 2: Create concrete classes implementing the same interface.

### Rectangle.java

```java
public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Rectangle");
   }
   
}
```

### Square.java

```java
public class Square implements Shape {

   @Override
   public void draw() {
      System.out.println("Square");
   }
   
}
```

### Circle.java

```java
public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Circle");
   }
   
}
```

## Step 3: Create a Factory to generate object of concrete class based on given information.

### ShapeFactory.java

```java
public class ShapeFactory {
	
   //use getShape method to get object of type shape 
   public Shape getShape(String shapeType) {
      if (shapeType == null) {
         return null;
      }	
      
      if (shapeType.equalsIgnoreCase("CIRCLE")) {
         return new Circle();
      } else if(shapeType.equalsIgnoreCase("RECTANGLE")) {
         return new Rectangle();
      } else if(shapeType.equalsIgnoreCase("SQUARE")) {
         return new Square();
      }
      
      return null;
   }
}
```

## Step 4: Use the Factory to get object of concrete class by passing an information such as type.

### Main.java

```java
public class Main {
   public static void main(String[] args) {
      ShapeFactory shapeFactory = new ShapeFactory();

      //get an object of Circle and call its draw method.
      Shape circle = shapeFactory.getShape("CIRCLE");

      //call draw method of Circle
      circle.draw();

      //get an object of Rectangle and call its draw method.
      Shape rectangle = shapeFactory.getShape("RECTANGLE");

      //call draw method of Rectangle
      rectangle.draw();

      //get an object of Square and call its draw method.
      Shape square = shapeFactory.getShape("SQUARE");

      //call draw method of square
      square.draw();
   }
}
```

### Output:

```
Circle
Rectangle
Square
```

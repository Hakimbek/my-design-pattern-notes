# Adapter Pattern
An Adapter Pattern says that just "converts the interface of a class into another interface that a client wants".

In other words, to provide the interface according to client requirement while using the services of a class with a different interface.

The Adapter Pattern is also known as **Wrapper**.

## Example of Adapter Pattern


### Step 1
Create bridge implementer interface.

### DrawAPI.java
```java
public interface DrawAPI {
   public void drawCircle(int radius, int x, int y);
}
```

### Step 2
Create concrete bridge implementer classes implementing the DrawAPI interface.

### RedCircle.java
```java
public class RedCircle implements DrawAPI {
   @Override
   public void drawCircle(int radius, int x, int y) {
      System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
   }
}
```

### GreenCircle.java
```java
public class GreenCircle implements DrawAPI {
   @Override
   public void drawCircle(int radius, int x, int y) {
      System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
   }
}
```

### Step 3
Create an abstract class Shape using the DrawAPI interface.

### Shape.java
```java
public abstract class Shape {
   protected DrawAPI drawAPI;
   
   protected Shape(DrawAPI drawAPI) {
      this.drawAPI = drawAPI;
   }
   public abstract void draw();	
}
```

### Step 4
Create concrete class implementing the Shape interface.

### Circle.java
```java
public class Circle extends Shape {
   private int x, y, radius;

   public Circle(int x, int y, int radius, DrawAPI drawAPI) {
      super(drawAPI);
      this.x = x;  
      this.y = y;  
      this.radius = radius;
   }

   public void draw() {
      drawAPI.drawCircle(radius,x,y);
   }
}
```

### Step 5
Use the Shape and DrawAPI classes to draw different colored circles.

### BridgePatternDemo.java
```java
public class BridgePatternDemo {
   public static void main(String[] args) {
      Shape redCircle = new Circle(100, 100, 10, new RedCircle());
      Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

      redCircle.draw();
      greenCircle.draw();
   }
}
```

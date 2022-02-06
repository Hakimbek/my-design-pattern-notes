# Builder Design Pattern

Builder Pattern says that "construct a complex object from simple objects using step-by-step approach"

It is mostly used when object can't be created in single step like in the de-serialization of a complex object.

## Example of Builder Design Pattern

## Step 1: Create an interface Item representing food item and packing.

### Item.java
```java
public interface Item {
   String name();
   Packing packing();
   double price();	
}
```

### Packing.java
```java
public interface Packing {
   String pack();
}
```

## Step 2: Create concrete classes implementing the Packing interface.

### Wrapper.java
```java
public class Wrapper implements Packing {
   @Override
   public String pack() {
      return "Wrapper";
   }
}
```

### Bottle.java
```java
public class Bottle implements Packing {
   @Override
   public String pack() {
      return "Bottle";
   }
}
```

## Step 3: Create abstract classes implementing the item interface providing default functionalities.

### Burger.java
```java
public abstract class Burger implements Item {
   @Override
   public Packing packing() {
      return new Wrapper();
   } 
}
```

### ColdDrink.java
```java
public abstract class ColdDrink implements Item {
   @Override
   public Packing packing() {
      return new Bottle();
   }
}
```

## Step 4: Create concrete classes extending Burger and ColdDrink classes

### VegBurger.java
```java
public class VegBurger extends Burger {
   @Override
   public double price() {
      return 25.0;
   }

   @Override
   public String name() {
      return "Veg Burger";
   }
}
```

### ChickenBurger.java
```java
public class ChickenBurger extends Burger {
   @Override
   public double price() {
      return 50.5;
   }

   @Override
   public String name() {
      return "Chicken Burger";
   }
}
```

### Coke.java
```java
public class Coke extends ColdDrink {
   @Override
   public double price() {
      return 30.0;
   }

   @Override
   public String name() {
      return "Coke";
   }
}
```

### Pepsi.java
```java
public class Pepsi extends ColdDrink {
   @Override
   public double price() {
      return 35.0;
   }

   @Override
   public String name() {
      return "Pepsi";
   }
}
```

## Step 5: Create a Meal class having Item objects defined above.

### Meal.java
```java
public class Meal {
   private List<Item> items = new ArrayList<Item>();	

   public void addItem(Item item) {
      items.add(item);
   }

   public double getCost() {
      float cost = 0.0;
      
      for (Item item : items) {
         cost += item.price();
      }		
      
      return cost;
   }

   public void showItems() {
      for (Item item : items) {
         System.out.print("Item: " + item.name());
         System.out.print(", Packing: " + item.packing().pack());
         System.out.println(", Price: " + item.price());
      }		
   }	
}
```

## Step 6: Create a MealBuilder class, the actual builder class responsible to create Meal objects.

### MealBuilder.java
```java
public class MealBuilder {

   public Meal prepareVegMeal () {
      Meal meal = new Meal();
      meal.addItem(new VegBurger());
      meal.addItem(new Coke());
      return meal;
   }   

   public Meal prepareNonVegMeal () {
      Meal meal = new Meal();
      meal.addItem(new ChickenBurger());
      meal.addItem(new Pepsi());
      return meal;
   }
}
```

## Step 7: Main uses MealBuider to demonstrate builder pattern.

### Main.java
```java
public class Main {
   public static void main(String[] args) {
   
      MealBuilder mealBuilder = new MealBuilder();

      Meal vegMeal = mealBuilder.prepareVegMeal();
      System.out.println("Veg Meal");
      vegMeal.showItems();
      System.out.println("Total Cost: " + vegMeal.getCost());

      Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
      System.out.println("\n\nNon-Veg Meal");
      nonVegMeal.showItems();
      System.out.println("Total Cost: " + nonVegMeal.getCost());
   }
}
```

### Output:

```
Non Vega Meal
Item: Chicken Burger, Packing: Wrapper, Price: 75.5
Item: Pepsi, Packing: Bottle, Price: 10.5
Total cost: 86.0

Veg Meal
Item: Veg Burger, Packing: Wrapper, Price: 50.25
Item: Coke, Packing: Bottle, Price: 15.25
Total cost: 65.5
```

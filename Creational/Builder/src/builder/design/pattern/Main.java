package builder.design.pattern;

public class Main {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("Non Vega Meal");
        nonVegMeal.showItems();
        System.out.println("Total cost: " + nonVegMeal.getCost());

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total cost: " + vegMeal.getCost());
    }
}

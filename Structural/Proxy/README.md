# Proxy Pattern
Simply, proxy means an object representing another object.

According to **GoF**, a Proxy Pattern *"provides the control for accessing the original object"*.

So, we can perform many operations like hiding the information of original object, on demand loading etc.

Proxy pattern is also known as **Surrogate** or **Placeholder**.

## Example of Proxy Pattern

## Step 1: Create an interface.

### Image.java

```java
public interface Image {
    void display();
}
```

## Step 2: Create concrete classes implementing the same interface.

### RealImage.java

```java
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk(filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }

    private void loadFromDisk(String filename) {
        System.out.println("Loading " + filename);
    }
}
```

### ProxyImage.java

```java
public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
```

## Step 3: Use the ProxyImage to get object of RealImage class when required.

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("myImage.png");

        //image will be loaded from disk
        image.display();

        //image will not be loaded from disk
        image.display();
    }
}
```

### Output:

```
Loading myImage.png
Displaying myImage.png
Displaying myImage.png
```

# Singleton design pattern in Java
Singleton Pattern says that just"define a class that has only one instance and provides a global point of access to it".

In other words, a class must ensure that only single instance should be created and single object can be used by all other classes.

There are two forms of singleton design pattern

- Early Instantiation: creation of instance at load time.
- Lazy Instantiation: creation of instance when required.

## Understanding early Instantiation of Singleton Pattern
In such case, we create the instance of the class at the time of declaring the static data member, so instance of the class is created at the time of classloading.

Let's see the example of singleton design pattern using early instantiation.

### File: A.java

```java
class A {  
  private static A obj = new A();  //Early, instance will be created at load time  
 
  private A() {
 
  }  
   
  public static A getA() {  
      return obj;  
  }  
  
  public void doSomething(){  
      //write your code  
  }  
}  
```

## Understanding lazy Instantiation of Singleton Pattern
In such case, we create the instance of the class in synchronized method or synchronized block, so instance of the class is created when required.

Let's see the simple example of singleton design pattern using lazy instantiation.

### File: A.java

```java
class A {  
    private static A obj;  
 
    private A() {
  
    }   
   
    public static A getA() {  
        if (obj == null) {  
            synchronized(Singleton.class) {  
                if (obj == null) {  
                    obj = new Singleton();  //instance will be created at request time  
                }  
            }              
        }  
        return obj;  
    }  
  
    public void doSomething(){  
        //write your code  
    }  
}  
```

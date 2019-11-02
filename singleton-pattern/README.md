# singleton-pattern
Project of example of singleton pattern implement by Java.

## What is singleton pattern
eliminate the option of instantiating more than one

class diagram:

![singleton-pattern](https://github.com/kan01234/design-patterns/blob/master/singleton-pattern/singleton-pattern.png/)

- only one instance will be created
- other classes get the SingletonObjec by getInstance() method
- SingletonObject can be created on first use

## When to use singleton pattern
- that object used by global, create and destory frequently
- want to control number of that object, reduce resources

## Example

- SingletonObject
```java
public class SingletonObject {

  private static SingletonObject instance  = new SingletonGreed();

  private SingletonObject() {
  }

  public static SingletonObject getInstance() {
    return instance;
  }

}
```
- easy to implemnet
- not lazy loading
- thread safe

- - - -

- SingletonObjectTwo
```java
private static SingletonObjectTwo instance  = null;

  private SingletonObjectTwo() {
  }

  public static SingletonObjectTwo getInstance() {
    if (instance == null) {
      instance = new SingletonObjectTwo();
    }
    return instance;
  }

}
```
- easy to implement
- lazy loading
- thread not safe

can add synchronized to getInstance() method, but the performance is not good if getInstance() call frequently:
```java
  public static synchronized SingletonObjectTwo getInstance() {
    if (instance == null) {
      instance = new SingletonObjectTwo();
    }
    return instance;
  }
```

to improve the performance in multi-threads:
```java
  public static SingletonObjectTwo getInstance() {
    if (instance == null) {
      synchronized(Singleton.class) {
        if(instance == null) {
          instance = new Singleton();
        }    
      }
    }
    return instance;
  }
```
- - - -
implement by enum
```java
public enum SingletonObjectThree {

  INSTANCE;

}
```
- easy to implement
- lazy load
- thread safe on create, but the method you added is based on your code

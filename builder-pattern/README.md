# builder-pattern
Project of eample of builder pattern implement by Java. 

## What is builder pattern
- used to create complex object
- separate construction code

class diagram:

![builder-pattern](https://github.com/kan01234/design-patterns/blob/master/builder-pattern/builder-pattern.png)

there are 4 roles in builder pattern:
1. Product
    - class that the user needed

2. Builder
    - abstract class or interface that define step needed to create a product correctly, and have a method to get a final product

3. Concrete Builder
    - class that implement or extends Builder and implmenet to create Product

4. Director
    - class that have construct method and take Builder object and provide method to call step from the builder to create final product. After that it can get the final product.

## When to use builder pattern
- avoid duplicate code for building a object
- create object independent from main process
- hide the creation code from client

## Example
need to create Animal, it need to have name, gender, weight and height

class diagram:

![builder-pattern-example](https://github.com/kan01234/design-patterns/blob/master/builder-pattern/builder-pattern-example.png)

Animal
```java
public class Animal {
    private String name;
    private double weight;
    private double height;
    private String gender;
    // getter, setter methods
}
```

AnimalBuilder, interface that represent to builder
```java
public interface AnimalBuilder {
    public AnimalBuilder setName(String name);
    public AnimalBuilder setWeight(double weight);
    public AnimalBuilder setHeight(double height);
    public AnimalBuilder setGender(String gender);
    public Animal build();
}
```

SmallDogBuilder, class that represent to concrete builder
```java
public class SmallDogBuilder implements AnimalBuilder {
    private String name;
    private double weight;
    private double height;
    private String gender;
    @Override
    public Animal build() {
        return new Animal()
                .setName(name)
                .setWeight(weight)
                .setHeight(height)
                .setGender(gender);
    }
    @Override
    public AnimalBuilder setName(String name) {
        this.name = name;
        return this;
    }
    @Override
    public AnimalBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }
    @Override
    public AnimalBuilder setHeight(double height) {
        this.height = height;
        return this;
    }
    @Override
    public AnimalBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
```

Testing code
```java
Animal pet;
AnimalBuilder animalBuilder = new SmallDogBuilder();
String name = "Dolly";
double weight = 20.0;
double height = 40.0;
String gender = "F";
pet = animalBuilder.setGender(gender)
        .setName(name)
        .setHeight(height)
        .setWeight(weight)
        .build();
System.out.println(pet);
assertTrue(pet instanceof Animal);
assertEquals("Dolly", pet.getName());
assertEquals(20.0, pet.getWeight());
assertEquals(40.0, pet.getHeight());
assertEquals("F", pet.getGender());
```

output
```
Animal [Gender=F, height=40.0, name=Dolly, weight=20.0]
```

when the user need an Animal object, user do not need to take care how to create it, only use the product from the PetEngineer class.

## Goods
- code is highly readably
- reduce parameter needed to construct object
- easy to make an immutable object
- object is ready to use

## Bads
- number of lines of code increased
- number of classes increased, since need to have ConcreteBuilder of each product

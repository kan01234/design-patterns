# interpreter-pattern
Project of example of interpreter pattern implement by Java.

## What is interpreter pattern
to evaluate sentences in a language

class diagram:

![interpreter-pattern](https://github.com/kan01234/design-patterns/blob/master/interpreter-pattern/interpreter-pattern.png)

1. Context
    - data need to be interprete

2. Expression
    - interface to define interprete method

3. Terminal Expression
    - class that implement Expression, and unable to extract to smaller expression

4. Non Terminal Expression
    - class that implement Expression, and able to extract to smaller expression

## Example
Assume we are taking a string a interprete it to lower case, add slash every 3 characters, to lower case and add slash.

class diagram:

![interpreter-pattern-example](https://github.com/kan01234/design-patterns/blob/master/interpreter-pattern/interpreter-pattern-example.png)

1. String is Context
2. Expression is expression
3. AddSlash and ToLowercase are TermainlExpression
4. ToLowercaseAndAddSlash is NonTerminalExpression

Expression interface define interprete method
```java
public interface Expression {
    public String interpret(String str);
}
```

AddSlash.java, add slash every 3 characters
```java
public class AddSlash implements Expression {

    @Override
    public String interpret(String str) {
        if (str == null || str.isEmpty())
            return str;

        final int size = 3;
        final String slash = "-";
        int start = 3;
        int strLength = str.length();
        String result = str.substring(0, Math.min(size, strLength));
        while (start < strLength) {
            result += slash + str.substring(start, Math.min(start + size, strLength));
            start += size;
        }
        return result;
    }

}
```

ToLowercase, change all character to lower case
```java
public class ToLowercase implements Expression {

    @Override
    public String interpret(String str) {
        return str.toLowerCase();
    }

}
```

ToLowercaseAndAddSlash, do both
```java
public class ToLowercaseAndAddSlash implements Expression {

    private static List<Expression> expressions = Arrays.asList(new ToLowercase(), new AddSlash());

    @Override
    public String interpret(String str) {
        String result = str;
        for(Expression expression : expressions)
            result = expression.interpret(result);
        return result;
    }

}
```

test code
```java
List<String> strs = Arrays.asList("hello", "GO TO School by bus", "bye bye");
Expression toLowercase = new ToLowercase();
Expression addSlash = new AddSlash();
Expression expression = new ToLowercaseAndAddSlash();

strs
        .stream()
        .map(str -> addSlash.interpret(str))
        .forEach(System.out::println);

strs
        .stream()
        .map(str -> toLowercase.interpret(str))
        .forEach(System.out::println);

strs
        .stream()
        .map(str -> expression.interpret(str))
        .forEach(System.out::println);
```

add slash output
```
hel-lo
GO -TO -Sch-ool- by- bu-s
bye- by-e
```

to lowercase output
```
hello
go to school by bus
bye bye
```

add slash and to lowercase
```
hel-lo
go -to -sch-ool- by- bu-s
bye- by-e
```

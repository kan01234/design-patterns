# chain-of-responsibility-pattern
Project of example of chain of responsibility pattern implement by Java.

## What is chain of responsibility pattern
- avoid coupling between sender and handler
- chain the handler and pass the request until a handler handle it

avoid below code:
```java
if (isA()) {
    // handle A
} else if (isB()) {
    // handle B
} else {
    // others case ...
}
```

class diagram:

![chain of responsibility pattern](https://github.com/kan01234/design-patterns/blob/master/chain-of-responsibility-pattern/chain-of-responsibility-pattern.png)

1. Handler
    - abstract class that define handleRequest method

2. ConcreteHandler1 and ComcreteHandler2
    - classes that extends Handler, implpement handleRequest method

sequence diagram:

![chain of responsibility pattern sequence](https://github.com/kan01234/design-patterns/blob/master/chain-of-responsibility-pattern/chain-of-responsibility-pattern-seq.png)

1. Client call the handleRequest method
2. ConcreteHandler1 handle it or pass to next
3. ConcreteHandler2 handle it or pass to next


## Example
assume we need to handle the mail by the its type, and there are two type "WORK" and "SPAM".

class diagram:

![chain of responsibility pattern example](https://github.com/kan01234/design-patterns/blob/master/chain-of-responsibility-pattern/chain-of-responsibility-pattern-example.png)

1. AbstractMailHandler
    - abstract class that define hadnelRequest method and constructor to accept next AbstractMailHandler

2. WorkMailHandler
    - class that extends AbstractMailHandler, for handling Work mail

3. SpamMailHandler
    - class that extends AbstractMailHandler, for handling Spam mail

AbstractMailHandler
```java
public abstract class AbstractMailHandler {

    protected AbstractMailHandler nextMailHandler;

    public abstract void handleRequest(Mail mail);

    public AbstractMailHandler(AbstractMailHandler nextMailHandler) {
        this.nextMailHandler = nextMailHandler;
    }

    protected void next(Mail mail) {
        if (nextMailHandler != null) {
            nextMailHandler.handleRequest(mail);
        } else {
            System.out.println("need manunal handle: " + mail);
        }
    }
}
```

WorkMailHandler
```java
public class WorkMailHandler extends AbstractMailHandler {

    private static final String HANDLE_TYPE = "WORK";

    // constructor method...

    @Override
    public void handleRequest(Mail mail) {
        if (HANDLE_TYPE.equals(mail.getType())) {
            System.out.println("work mail received, add to task list");
        } else {
            next(mail);
        }
    }

}
```

Mail
```java
public class Mail {

    private String type;

    public Mail(String type) {
        this.type = type;
    }

    // getter, setter ...

}
```

creating a mail handler
```java
AbstractMailHandler mailHandler = new WorkMailHandler(new SpamMailHandler(null));
```

handle work mail
```java
mailHandler.handleRequest(new Mail("WORK"));
```

output
```
work mail received, add to task list
```

handle spam mail
```java
mailHandler.handleRequest(new Mail("SPAM"));
```

output
```
spam mail received, ignore it
```

handle other mail
```java
mailHandler.handleRequest(new Mail("OTHER"));
```

output
```
need manunal handle: Mail [type=OTHER]
```

you can add one more handler from gerneral case

GeneralMailHandler
```java
public class GeneralMailHandler extends AbstractMailHandler {

    // constructor method...

    @Override
    public void handleRequest(Mail mail) {
        System.out.println("need manunal handle: " + mail);
    }

}
```

and change the creating AbstractMailHandler object to
```java
AbstractMailHandler mailHandler = new WorkMailHandler(new SpamMailHandler(new GeneralMailHandler(null)));
```

but need to be careful the sequence of the mail handler objects. Since there are running in sequence, if we put GeneralMailHandler as first handler, all of the case will handle by that.

also this pattern it not ensure the object get handle, you can check when withou GeneralMailHandler, the object will not get handled.

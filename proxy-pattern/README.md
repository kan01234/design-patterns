# proxy-pattern
Project of eample of proxy pattern implement by Java.

## What is proxy pattern
provide a proxy object to control access to real object

class diagram:

![proxy pattern](https://github.com/kan01234/design-patterns/blob/master/proxy-pattern/proxy-pattern.png)

1. IObject
    - interface that define the methods of real object and proxy, allow proxy objext can be handle like readl object

2. RealObject
    - class that implement IObject, real object really need to create

3. ProxyObject
    - class that implement IObject, control acces to real object

## When to use proxy pattern
- control access to real object
- additional function need to be implement to access real object

## Example (Virtual Proxy)
assume we are having a Book object, and the book contians a large String, also need to perfom some heavy calcution on create. To improve the performance. Use proxy to access to real book object, and create the book object when really need it. Something like lazy loading.

class diagram:

![proxy pattern example 1](https://github.com/kan01234/design-patterns/blob/master/proxy-pattern/proxy-pattern-example-1.png)

1. BookInterface is IObject
2. Book is RealObject
3. BookProxy is ProxyObject

Assume having large string in Book, and calculate total pages and chapters by the content when creating a book object.
And the client need to get the content, number of chapters, number of pages of book.

BookInterface
```java
public interface BookInterface {
    
    public String getContent();

    public int getNumOfChapter();

    public int getNumOfPage();

}
```

BookProxy

BookProxy will init a Book Object when user first use of it
```java
public class BookProxy implements BookInterface {

    private String content;

    private Book book;

    public BookProxy(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        if (book == null)
            book = new Book(content);
        return book.getContent();
    }

    // other implements methods ...
}
```

Book
```java
public class Book implements BookInterface {

    private String content;

    private int numOfPage;

    private int numOfChapter;

    public Book (String content) {
        this.content = content;
        init();
    }

    private void init() {
        System.out.println("expensive init action from book");
        // some long processing
    }

    // getter and setter methods ...

}
```

Test code
```java
public void test() {
    BookInterface bookProxy = new BookProxy("some long text...");
    // method return book object in BookProxy for testing
    book = (((BookProxy) bookProxy).getBook());
    System.out.println(book);
    assertEquals(bookProxy.getContent(), book.getContent());
    assertEquals(bookProxy.getNumOfChapter(), book.getNumOfChapter());
    assertEquals(bookProxy.getNumOfPage(), book.getNumOfPage());
}
```

```output
expensive init action from book
```

we can see that the book object only create once

## Example (Protection Proxy)
assume we have a printer, but only specific role users are allow to print.

class diagram:

![proxy pattern example 2](https://github.com/kan01234/design-patterns/blob/master/proxy-pattern/proxy-pattern-example-2.png)

1. PrinterInterface is IObject
2. Printer is RealObject
3. PrinterProxy is ProxyObject

PrinterInterface
```java
public interface PrinterInterface {

    public void print(String data, String role);

}
```

Printer

real object, simple print out the data to console
```java
public class Printer implements PrinterInterface {

    @Override
    public void print(String data, String role) {
        System.out.println("print:\n" + data + "\n---");
    }

}
```

PrinterProxy

check role is exists in allowRoles, and pass to printer object

otherwise print error message
```java
public class PrinterProxy implements PrinterInterface {

    private Printer printer;

    private static final Set<String> allowRoles; // MANAGER, ADMIN

    // constructor, static init code...

    @Override
    public void print(String data, String role) {
        if (allowRoles.contains(role))
            printer.print(data, role);
        else
            System.out.println("access to printer denied, your role: " + role);
    }

}
```

Test

only allow MANAGER, ADMIN to print
```java
PrinterInterface printerProxy = new PrinterProxy();
printerProxy.print("some content", "STAFF");
printerProxy.print("aabbccddeeffgg", "ADMIN");
```

output
```
access to printer denied, your role: STAFF
print:
aabbccddeeffgg
---
```
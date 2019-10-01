package com.dotterbear.proxy.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    public void test() {
        // long text
        String content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut imperdiet pulvinar justo, et mollis quam consectetur at. Nullam egestas justo a nunc dapibus rutrum. Vivamus ligula lacus, bibendum a laoreet ut, egestas eget turpis. Aliquam at vestibulum elit, a mollis sapien. Fusce eu mattis nulla, sed finibus dolor. Sed imperdiet odio vel consectetur semper. Nulla maximus malesuada dolor eget sollicitudin. Vestibulum sed auctor nulla. Curabitur dignissim non leo ac luctus. Pellentesque hendrerit, ligula non fringilla congue, felis tellus tempor eros, non ullamcorper risus arcu sit amet magna. Praesent diam lectus, scelerisque vel nisl eu, tempor consequat odio. Morbi tempor ultrices tortor sed consectetur. Curabitur et leo metus. Nullam purus augue, lobortis non elit id, consequat tincidunt lorem. Maecenas gravida tellus odio. ";
        BookInterface bookProxy = new BookProxy(content);
        BookInterface book = (((BookProxy) bookProxy).getBook());
        assertEquals(book, null);
        bookProxy.getContent();
        book = (((BookProxy) bookProxy).getBook());
        assertNotNull(book);
        assertEquals(bookProxy.getContent(), book.getContent());
        assertEquals(bookProxy.getNumOfChapter(), book.getNumOfChapter());
        assertEquals(bookProxy.getNumOfPage(), book.getNumOfPage());
    }

    @Test
    public void test2() {
        PrinterInterface printerProxy = new PrinterProxy();
        printerProxy.print("some content", "STAFF");
        printerProxy.print("aabbccddeeffgg", "ADMIN");
    }

}
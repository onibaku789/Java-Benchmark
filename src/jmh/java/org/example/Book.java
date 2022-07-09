package org.example;


import net.datafaker.Address;

public record Book(String author, String title, String genre, Publisher publisher) {
    public static Book of(net.datafaker.Book book, Address address) {
        return new Book(book.author(), book.title(), book.genre(), Publisher.of(address));
    }
}

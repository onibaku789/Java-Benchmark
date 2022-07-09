package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.*;
import net.datafaker.fileformats.Format;

import java.io.FileWriter;
import java.io.IOException;

public class DataGenerator {
    Faker faker = new Faker();

    public static void main(String[] args) {
        try {
            new DataGenerator().generateDataAndWriteJson(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateDataAndWriteJson(int numberOfBooks) throws IOException {
        FakeCollection<Book> bookFakeCollection = faker.<Book>collection()
                .suppliers(faker::book)
                .maxLen(numberOfBooks)
                .minLen(numberOfBooks)
                .build();
        FakeCollection<Address> addressFakeCollection = faker.<Address>collection()
                .suppliers(faker::address)
                .maxLen(1)
                .minLen(1)
                .build();
        String json = Format.toJson(bookFakeCollection)
                .set("author", Book::author)
                .set("title", Book::title)
                .set("genre", Book::genre)
                .set("publisher",
                        Format.toJson(addressFakeCollection)
                                .set("country", Address::country)
                                .set("city", Address::city)
                                .set("zipcode", Address::zipCode)
                                .set("streetAddress", Address::streetAddress)
                                .build())
                .build()
                .generate();

        FileWriter fileWriter = new FileWriter("test.json");
        new ObjectMapper().writeValue(fileWriter, json);

    }
}

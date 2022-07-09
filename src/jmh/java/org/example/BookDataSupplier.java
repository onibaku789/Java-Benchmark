package org.example;



import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.nio.file.Path;
import java.util.List;

@State(Scope.Benchmark)
public class BookDataSupplier {
    public List<Book> books() {
        return books;
    }

    private List<Book> books;


    @Setup(Level.Trial)
    public void setUp() {
        Path testFile = Path.of("test.json");
        System.out.println("TestFile exists :" + testFile.toFile().exists());
    }

}

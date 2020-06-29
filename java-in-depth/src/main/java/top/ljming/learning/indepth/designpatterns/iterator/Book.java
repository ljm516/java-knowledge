package top.ljming.learning.indepth.designpatterns.iterator;

import lombok.Data;

/**
 * 书.
 *
 * @author ljming
 */
@Data
public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }
}

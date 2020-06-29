package top.ljming.learning.indepth.designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 书架.
 *
 * 角色: 具体的集合，负责实现Aggregate角色所定义的接口。会创建出具体的迭代器.
 * @author ljming
 */
public class BookShelf implements Aggregate {

//    private Book[] books;
    private List<Book> books;
    private int last = 0;

    public BookShelf(int maxSize) {
        this.books = new ArrayList<>(maxSize);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}

package top.ljming.learning.indepth.designpatterns.iterator;

/**
 * 遍历书架的类.
 *
 * 角色: 具体的迭代器
 * @author ljming
 */
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;

    private int index;


    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}

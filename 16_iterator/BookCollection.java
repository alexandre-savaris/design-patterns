import java.util.Iterator;

public class BookCollection implements Iterable<Book> {
    private Book[] books;
    private int size = 0;

    public BookCollection(int capacity) {

        this.books = new Book[capacity];
    }

    public void addBook(Book book) {

        if (this.size < this.books.length) {
            this.books[this.size++] = book;
        }
    }

    @Override
    public Iterator<Book> iterator() {

        return new BookIterator();
    }

    private class BookIterator implements Iterator<Book> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {

            return this.currentIndex < size && books[this.currentIndex] != null;
        }

        @Override
        public Book next() {

            return books[this.currentIndex++];
        }
    }
}

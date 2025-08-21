public class Library {

    public static void main(String[] args) {

        BookCollection myBooks = new BookCollection(5);
        myBooks.addBook(new Book("The Hobbit"));
        myBooks.addBook(new Book("1984"));
        myBooks.addBook(new Book("Dune"));

        System.out.println("My Book Collection");

        for (Book book : myBooks) {
            System.out.println(book.getTitle());
        }
    }
}

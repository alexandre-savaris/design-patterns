public interface ShoppingCartVisitor {

    double visit(Book book);
    double visit(Electronic electronic);
}

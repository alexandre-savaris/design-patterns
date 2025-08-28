public class Book implements ItemElement {
    private double price;
    private double weight;

    public Book(double price, double weight) {

        this.price = price;
        this.weight = weight;
    }

    public double getPrice() {

        return price;
    }

    public double getWeight() {

        return weight;
    }

    @Override
    public double accept(ShoppingCartVisitor visitor) {

        return visitor.visit(this);
    }
}

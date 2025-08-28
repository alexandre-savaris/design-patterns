public class Electronic implements ItemElement {
    private double price;
    private double weight;
    private boolean isFragile;

    public Electronic(double price, double weight, boolean isFragile) {

        this.price = price;
        this.weight = weight;
        this.isFragile = isFragile;
    }

    public double getPrice() {

        return price;
    }

    public double getWeight() {

        return weight;
    }

    public boolean isFragile() {

        return isFragile;
    }

    @Override
    public double accept(ShoppingCartVisitor visitor) {

        return visitor.visit(this);
    }
}

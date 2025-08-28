public class ShippingCostVisitor implements ShoppingCartVisitor {

    @Override
    public double visit(Book book) {

        double cost = book.getWeight() * 2;
        System.out.println("Book shipping cost: $" + cost);

        return cost;
    }

    @Override
    public double visit(Electronic electronic) {

        double cost = electronic.getWeight() * 5;
        if (electronic.isFragile()) {
            cost += 10;
        }
        System.out.println("Electronic shipping cost: $" + cost);

        return cost;
    }
}

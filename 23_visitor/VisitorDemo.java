import java.util.ArrayList;
import java.util.List;

public class VisitorDemo {

    public static void main(String[] args) {

        List<ItemElement> items = new ArrayList<>();
        items.add(new Book(20, 2));
        items.add(new Electronic(200, 3, true));
        items.add(new Electronic(150, 5, false));

        calculateTotal(items);
    }

    private static void calculateTotal(List<ItemElement> items) {

        ShoppingCartVisitor visitor = new ShippingCostVisitor();
        double totalCost = 0;
        for (ItemElement item : items) {
            totalCost += item.accept(visitor);
        }
        System.out.println("-----------------------------");
        System.out.println("Total Shipping Cost: $" + totalCost);
    }
}

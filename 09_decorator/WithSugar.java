public class WithSugar extends CoffeeDecorator {

    public WithSugar(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {

        return super.getCost() + 0.25;
    }

    @Override
    public String getDescription() {

        return super.getDescription() + ", with sugar.";
    }
}

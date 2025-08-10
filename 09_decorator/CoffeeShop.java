public class CoffeeShop {

    public static void main(String[] args) {

        Coffee myCoffee = new SimpleCoffee();
        System.out.println(myCoffee.getDescription() + " costs $" + myCoffee.getCost());

        myCoffee = new WithMilk(myCoffee);
        myCoffee = new WithSugar(myCoffee);

        System.out.println(myCoffee.getDescription() + " costs $" + myCoffee.getCost());

        Coffee anotherCoffee = new WithSugar(new WithMilk(new SimpleCoffee()));
        System.out.println("Final order: " + anotherCoffee.getDescription());
        System.out.println("Final cost: " + anotherCoffee.getCost());
    }
}

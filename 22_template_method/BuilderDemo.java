public class BuilderDemo {

    public static void main(String[] args) {

        System.out.println("--- Building a  Wooden house ---");
        HouseTemplate woodenHouse = new WoodenHouse();
        woodenHouse.buildHouse();

        System.out.println("\n--- Building a  Glass house ---");
        HouseTemplate glassHouse = new GlassHouse();
        glassHouse.buildHouse();
    }
}

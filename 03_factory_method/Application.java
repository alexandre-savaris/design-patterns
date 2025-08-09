public class Application {
    private static Logistics logistics;

    public static void main(String[] args) {
        String deliveryType = "sea";

        if (deliveryType.equalsIgnoreCase("sea")) {
            logistics = new SeaLogistics();
        } else if (deliveryType.equalsIgnoreCase("road")) {
            logistics = new RoadLogistics();
        } else {
            throw new IllegalArgumentException("Unknown delivery type.");
        }

        logistics.planDelivery();
    }
}

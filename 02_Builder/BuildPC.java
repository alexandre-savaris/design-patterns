public class BuildPC {

    public static void main(String[] args) {

        Computer basicComputer = new Computer.Builder("Intel i5", "16GB").build();
        System.out.println(basicComputer);

        Computer gamingComputer = new Computer.Builder("AMD Ryzen 9", "64GB")
            .withGraphicsCard("NVIDIA RTX 4090")
            .withBluetooth(true)
            .build();
        System.out.println(gamingComputer);
    }
}

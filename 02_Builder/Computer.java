public class Computer {
    // Required attributes.
    private final String cpu;
    private final String ram;
    // Optional attributes.
    private final String graphicsCard;
    private final boolean hasBluetooth;

    private Computer(Builder builder) {

        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.graphicsCard = builder.graphicsCard;
        this.hasBluetooth = builder.hasBluetooth;
    }

    @Override
    public String toString() {

        return "Computer [CPU=" + this.cpu
            + ", RAM=" + this.ram
            + ", GraphicsCard=" + this.graphicsCard
            + ", Bluetooth=" + this.hasBluetooth + "]";
    }

    public static class Builder {
        // Required attributes.
        private final String cpu;
        private final String ram;
        // Optional attributes.
        private String graphicsCard = "Integrated";
        private boolean hasBluetooth = false;

        public Builder(String cpu, String ram) {

            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder withGraphicsCard(String graphicsCard) {

            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder withBluetooth(boolean hasBluetooth) {

            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Computer build() {

            return new Computer(this);
        }
    }
}

public abstract class HouseTemplate {

    public final void buildHouse() {

        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("The house is built!");
    }

    protected abstract void buildPillars();
    protected abstract void buildWalls();

    private void buildFoundation() {

        System.out.println("Building foundation with cement, iron rods, and sand.");
    }

    private void buildWindows() {

        System.out.println("Building glass windows.");
    }
}

public class PrototypeDemo {

    public static void main(String[] args) {

        ShapeCache.loadInitialCache();

        Shape cloneShape1 = ShapeCache.getShape("1");
        System.out.println(cloneShape1.getType());

        Shape cloneShape2 = ShapeCache.getShape("2");
        System.out.println(cloneShape2.getType());
    }
}

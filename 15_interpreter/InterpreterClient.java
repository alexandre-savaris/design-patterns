public class InterpreterClient {

    public static void main(String[] args) {

        Expression expression = new MinusExpression(
            new PlusExpression(
                new NumberExpression(10),
                new NumberExpression(5)
            ),
            new NumberExpression(3)
        );
        int result = expression.interpret();
        System.out.println("The result of '10 + 5 - 3' is: " + result);
    }
}

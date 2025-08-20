public class PlusExpression implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public PlusExpression(Expression leftExpression, Expression rightExpression) {

        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {

        return this.leftExpression.interpret() + this.rightExpression.interpret();
    }
}

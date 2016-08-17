/**
 * A Conditional is an if-then-else expression.
 */
public class Conditional implements Expression {

    private Expression test;
    private Expression ifTrue;
    private Expression ifFalse;

    /**
     * Creates a Conditional with the specified components.
     * @param test an expression which evaluates to true or false
     * @param ifTrue the expression to evaluate if the test returns true
     * @param ifFalse the expression to evaluate if the test returns false
     */
    public Conditional(Expression test,
                       Expression ifTrue,
                       Expression ifFalse){
        this.test = test;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    public Value eval(Environment env){
        Boolean b = test.eval(env).as(Boolean.class);
        if(b){
            return ifTrue.eval(env);
        } else {
            return ifFalse.eval(env);
        }
    }
    public String toString()
    {
    	return "(if " + test + " then " + ifTrue + " else " + ifFalse + ")";
    }
}
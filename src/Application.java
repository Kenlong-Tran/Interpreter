/**
 * An Application is an expression that when evaluated
 * applies a function value (found by evaluating the operator)
 * to some argument value (found by evaluating the operand).
 */
public class Application implements Expression {

    private Expression operator;
    private Expression operand;

    /**
     * Create an Application with the specified components.
     * @param operator the expression which computes the function
     * @param operand the expression which computes the argument
     */
    public Application(Expression operator, Expression operand){
        this.operator = operator;
        this.operand = operand;
    }
    public Expression getOperator()
    {
    	return operator;
    }
	
    public Value eval(Environment env) {
        Function fun = operator.eval(env).as(Function.class);
        return fun.apply(operand.eval(env));
    }
    
    
    public String toString()
    {
    	return "(" + operator + " " + operand + ")";
    }
    
    
}

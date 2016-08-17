/**
 * A Constant is an expression with a directly specified value.
 */
public class Constant implements Expression {

    private Value value;

    /**
     * Creates a Constant for a Value representing the specified Object.
     * This is a convenience constructor; for example
     *   new Constant(17)
     * is equivalent to, but more convenient than,
     *   new Constant(new BoxedValue(17)).
     * @param obj the Object to be packaged into a BoxedValue
     */
    public Constant(Object obj){
        this(new BoxedValue(obj));
    }

    /**
     * Creates a Constant with the specified Value.
     * @param value the Value the expression should evaluate to
     */
    public Constant(Value value){
        this.value = value;
    }

    public Value eval(Environment env){
        return value;
    }
    public String toString()
    {
    	return value.toString();
    }
}
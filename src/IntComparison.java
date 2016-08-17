/**
 * An abstract base class for integer comparison functions such as
 * &lt;. These functions are all "curried", which means that they
 * expect one argument (the left operand) and then produce a new
 * function which in turn expects one argument (the right operand)
 * before producing the final true/false result. This is necessary
 * because we are requiring all functions to take just one argument.
 */
public abstract class IntComparison extends PrimitiveFunction {
    
    /**
     * This method should be implemented in each concrete subclass.
     * This is where the actual comparison takes place, whether that
     * be &lt;, &gt;, or whatnot.
     * @param i1 the left operand
     * @param i2 the right operand
     * @return the result of comparing i1 with i2
     */
    public abstract boolean compute(int i1, int i2);
	
    public Value apply(Value arg1) {
        final Integer i1 = arg1.as(Integer.class);
        return new FunctionBase(){
            public Value apply(Value arg2){
                Integer i2 = arg2.as(Integer.class);
                return new BoxedValue(compute(i1,i2));
            }
            
            public String toString(){
            	return "(" + IntComparison.this + " " + i1 + ")";
            }
        };
    }
}
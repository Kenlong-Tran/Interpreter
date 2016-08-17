/**
 * An abstract base class for integer arithmetic functions such as
 * +. These functions are all "curried", which means that they expect
 * one argument (the left operand) and then produce a new function
 * which in turn expects one argument (the right operand) before
 * producing the final result of the arithmetic. This is necessary
 * because we are requiring all functions to take just one argument.
 */
public abstract class IntOperation extends PrimitiveFunction {

    
    /**
     * This method should be implemented in each concrete subclass.
     * This is where the actual operation takes place, whether that
     * be +, -, or whatnot.
     * @param i1 the left operand
     * @param i2 the right operand
     * @return the result of the computation on i1 and i2
     */
    public abstract int compute(int i1, int i2);
	
    public Value apply(Value arg1) {
        final Integer i1 = arg1.as(Integer.class);
        return new FunctionBase(){
            public Value apply(Value arg2){
                Integer i2 = arg2.as(Integer.class);
                return new BoxedValue(compute(i1,i2));
            }
            
            public String toString(){
            	return "(" + IntOperation.this + " " + i1 + ")";
            }
        };
    }
}
/**
 * The run-time representation of a function (that is, a
 * procedure). This is a Value that can be applied to another Value
 * (the function's argument), so as to compute yet another Value (the
 * function's result).
 */
public interface Function extends Value {

    /**
     * Apply this function to a specified argument Value.
     * @param argument the argument Value
     * @return the result Value from the function application.
     */
    Value apply(Value argument);
}
/**
 * The representation of an expression; in other words, an AST.
 */
public interface Expression {

    /**
     * Evaluate this expression.  
     * When an Expression is evaluated, this must happen in some
     * particular environment. For example, evaluating the variable x
     * in one environment might produce a totally different value than
     * evaluating it in another environment.
     * @param env the environment in which the expression should be evaluated
     * @return the value produced by the expression
     */
    Value eval(Environment env);
}
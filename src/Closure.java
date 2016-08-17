/**
 * A Closure is a function defined by code being interpreted (either a
 * function definition or a lambda expression), rather than being one
 * of the built-in functions such as +.
 */
public class Closure extends FunctionBase {

    private String parameter;
    private Expression body;
    private Environment env;

    /**
     * Creates a Closure with the specified components.
     * @param parameter the name used in the function for its input
     * @param body the expression evaluated when the function is used
     * @param env the environment in which the function was created
     */
    public Closure(String parameter,
                   Expression body,
                   Environment env){
        this.parameter = parameter;
        this.body = body;
        this.env = env;
    }

    public Value apply(Value argument){
        return body.eval(new ActivationRecord(parameter, argument, env));
    }

	@Override
	public String toString(){
		return "(" + parameter + "=>" + body + ")";
	}
}
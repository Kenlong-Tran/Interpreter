/**
 * A Variable is a name used as an expression.
 */
public class Variable implements Expression {

    private String name;

    /**
     * Creates a Variable with the specified name.
     * @param name the name for this variable
     */
    public Variable(String name){
        this.name = name;
    }

    public Value eval(Environment env){
        return env.get(name);
    }
    public String toString()
    {
    	return name;
    }
}

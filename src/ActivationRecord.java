/**
 * An ActivationRecord is an environment in which one new name is
 * bound to some value, while all other names retain the values they
 * have in some pre-existing outer environment, accessed via a nesting
 * link.
 */
public class ActivationRecord implements Environment {

    private String name;
    private Value value;
    private Environment nestingLink;

    /**
     * Creates an activation record that binds a name to an ordinary value.
     * This is the kind of binding used for ML's "val".
     * @param name the name being bound
     * @param value the value the name is bound to
     * @param nestingLink the environment being augmented
     */
    public ActivationRecord(String name,
                            Value value,
                            Environment nestingLink){
        this.name = name;
        this.value = value;
        this.nestingLink = nestingLink;
    }

    /**
     * Creates an activation record that binds a name to a
     * value that is a (possibly recursive) function.
     * This is the kind of binding used for ML's "fun".
     * @param functionName the name being bound
     * @param parameterName the function's parameter
     * @param functionBody the function's body
     * @param nestingLink the environment being augmented
     */
    public ActivationRecord(String functionName,
                            String parameterName,
                            Expression functionBody,
                            Environment nestingLink){
        name = functionName;
        value = new Closure(parameterName, functionBody, this);
        this.nestingLink = nestingLink;
    }

    public Value get(String name){
        if(name.equals(this.name)){
            return value;
        } else {
            return nestingLink.get(name);
        }
    }
}
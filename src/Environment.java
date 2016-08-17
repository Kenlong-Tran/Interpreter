/**
 * An Environment provides the correspondence between names and the
 * values that they are names for.
 */
public interface Environment {

    /**
     * Return the value corresponding to the specified name.
     * @param name the name to look up
     * @return the value associated with the name
     * @throws IllegalArgumentException if the name is not associated with any value
     */
    Value get(String name);
}
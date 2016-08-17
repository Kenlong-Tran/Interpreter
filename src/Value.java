/**
 * Represents a value processed by the interpreted program.
 * @author max
 */
public interface Value {
	/**
	 * Retrieves the underlying object represented by this Value.
	 * For example, if the value represents an integer, this
	 * could be used to convert from the Value type to Integer.
	 * @param type is what this Value is expected to represent
	 * @return an instance of type that is represented by this Value
	 * @throws ClassCastException if the expectation isn't met
	 */
	public <T> T as(Class<T> type);
}

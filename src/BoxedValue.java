/**
 * Holds an Object used as a Value processed by the interpreted program.
 * @author max
 */
public class BoxedValue extends ValueBase {
	private Object obj;

	/**
	 * Converts a Java Object (an Integer, for example) into a Value
	 * @param obj the Object that this Value will represent
	 */
	public BoxedValue(Object obj) {
		this.obj = obj;
	}
	
	@Override
	public String toString(){
		return obj.toString();
	}

	protected Object getObject() {
		return obj;
	}
	
}

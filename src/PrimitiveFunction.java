/**
 * A function the name of which is known by the InitialEnvironment.
 * @author max
 *
 */
public abstract class PrimitiveFunction extends FunctionBase {

	public String toString() {
		return InitialEnvironment.getEnvironment().getName(this);
	}

}
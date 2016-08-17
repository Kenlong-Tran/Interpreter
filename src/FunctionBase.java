/**
 * An abstract class providing the portion of the Function interface
 * that comes from the Value interface.  Extending this abstract
 * base class is a convenient way for an implementation of Function
 * to meet that part of its obligations.
 * @author max
 *
 */
public abstract class FunctionBase extends ValueBase implements Function {

	@Override
	protected Object getObject(){
		return this;
	}

}

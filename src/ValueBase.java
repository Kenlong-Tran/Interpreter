/**
 * An abstract class providing much of the code for the Value interface.
 * Extending this abstract base class is a convenient way for an
 * implementation of Value to meet the obligation imposed by that interface.
 * @author max
 *
 */
public abstract class ValueBase implements Value {
	
	/**
	 * Subclasses implement this to provide the Object that the
	 * as method will cast to the correct type.
	 * @return the underlying Object represented by this Value
	 */
	protected abstract Object getObject();

	@Override
	public <T> T as(Class<T> type){
		Object o = getObject();
		try{
			return type.cast(o);
		} catch(ClassCastException e){
			// rethrow the ClassCastException with a more clear message
			throw new ClassCastException("The Value " + o + 
					" can't be used as " + 
					type.getSimpleName());
		}
	}

}

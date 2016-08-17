/**
 * An IntList is a list of ints.
 */
public class IntList {
	private ConsCell start; // first in the list or null
	
	/**
	 * The empty IntList.
	 */
	public static final IntList NIL = new IntList(null);

	/**
	 * Construct a new IntList given its first ConsCell.
	 * @param s the first ConsCell in the list or null
	 */
	private IntList(ConsCell s) {
		start = s;
	}

	/**
	 * Cons the given element h onto us and return the
	 * resulting IntList.
	 * @param h the head int for the new list
	 * @return the IntList with head h and us for a tail
	 */
	public IntList cons (int h) {
		return new IntList(new ConsCell(h,start));
	}
	
	/**
	 * Get our length.
	 * @return our int length
	 */
	public int length() {
		int len = 0;
		ConsCell cell = start;
		while (cell != null) { // while not at end of list
			len++;
			cell = cell.getTail();
		}
		return len;
	}

	/**
	 * Convert this IntList to a String.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		ConsCell a = start;
		while (a != null) {
			s.append(a.getHead());
			a = a.getTail();
			if (a != null) s.append(",");
		}
		s.append("]");
		return s.toString();
	}

	/**
	 * A ConsCell is an element in a linked list of
	 * ints.
	 */
	private static class ConsCell {
		private int head; // the first item in the list
		private ConsCell tail; // rest of the list or null

		/** 
		 * Construct a new ConsCell given its head and tail.
		 * @param h the int contents of this cell
		 * @param t the next ConsCell in the list or null
		 */
		public ConsCell(int h, ConsCell t) {
			head = h;
			tail = t;
		}
		/**
		 * Accessor for the head of this ConsCell.
		 * @return the int contents of this cell
		 */
		public int getHead() {
			return head;
		}

		/**
		 * Accessor for the tail of this ConsCell.
		 * @return the next ConsCell in the list or null
		 */
		public ConsCell getTail() {
			return tail;
		}

	}
}
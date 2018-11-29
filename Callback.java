package test.callback;

import java.util.HashMap;
import java.util.Map;

/**
 * Java class for improving callback readability
 * @see jjking2/callback@github
 */
public class Callback {

	public enum Tag {
		X,
		Y,
		Z
	}
	
	/** map of callback tag and callback code */
	private Map<Tag, Runnable> callbacks = new HashMap<Tag, Runnable>();
	
	/**
	 * Set a pair of a callback-time selection tag and the runnable to be run if matched
	 * @param tag selection tag
	 * @param r callback handler
	 */
	public void setCallback(Tag tag, Runnable r) {
		callbacks.put(tag, r);
	}

	/**
	 * get a runnable associated with the callback-time selection tag.
	 * @param tag selection tag
	 * @return callback handler
	 */
	public Runnable getCallback(Tag tag) {
		return (Runnable)callbacks.get(tag);
	}
}

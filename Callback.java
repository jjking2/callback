package test.callback;

import java.util.HashMap;
import java.util.Map;

public class Callback {

	public enum Tag {
		X,
		Y,
		Z
	}
	
	private Map<Tag, Runnable> callbacks = new HashMap<Tag, Runnable>();
	
	public void setCallback(Tag tag, Runnable r) {
		callbacks.put(tag, r);
	}
	
	public Runnable getCallback(Tag tag) {
		return (Runnable)callbacks.get(tag);
	}
}

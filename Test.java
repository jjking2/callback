package test.callback;

public class Test {

	private Callback callback = new Callback();

	private void log(String s) {
		System.out.println(s);
	}
	
	private void runX() {
		log("runX called");
		onX();
	}

	private void runY() {
		log("runY called");
		onYorZ(true);
	}

	private void runZ() {
		log("runZ called");
		onYorZ(false);
	}

	private void onX() {
		log("onX called");
		callback.getCallback(Callback.Tag.X).run();
	}

	private void onYorZ(boolean isY) {
		log("onYorZ called with isY = " + isY);
		if (isY) callback.getCallback(Callback.Tag.Y).run();
		else callback.getCallback(Callback.Tag.Z).run();
	}

	private void run() {
		callback.setCallback(Callback.Tag.X, new Runnable() {
			@Override
			public void run() {
				log("callback for X called");
				double r = Math.random();
				log(" random = " + r);
				if (r < 0.5) runY();
				else runZ();
			}
		});
		
		callback.setCallback(Callback.Tag.Y, new Runnable() {
			@Override
			public void run() {
				log("callback for Y called");
			}
		});

		callback.setCallback(Callback.Tag.Z, new Runnable() {
			@Override
			public void run() {
				log("callback for Z called");
			}
		});

		runX();
	}
	
	public static void main(String[] args) {
		(new Test()).run();
	}
}

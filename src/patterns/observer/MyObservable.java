package patterns.observer;

import java.util.Observable;

public class MyObservable extends Observable {

	public MyObservable() {

	}

	public void modify() {
		setChanged();
		notifyObservers("Asd");
	}

}

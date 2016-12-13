package patterns.observer;

import java.util.Observable;

public class Observer implements java.util.Observer{

	public static void main(String[] args) {
		
		Observer observer = new Observer();
		
		MyObservable observableSubject = new MyObservable();
		observableSubject.addObserver(observer);
		System.out.println(observableSubject.countObservers());

		observableSubject.modify();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("got "+arg);
	}

}

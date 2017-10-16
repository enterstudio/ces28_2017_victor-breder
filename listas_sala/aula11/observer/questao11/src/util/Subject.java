package util;

import java.util.ArrayList;

public abstract class Subject {

	protected ArrayList<Observer> observers = new ArrayList<Observer>();

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void dettach(Observer observer) {
		observers.remove(observer);
	}

	protected void avisar() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

}

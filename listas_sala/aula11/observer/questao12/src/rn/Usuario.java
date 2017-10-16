package rn;

import java.util.Observable;

public class Usuario extends Observable {
	
	private String state;
	
	public void setState(String state) {
		this.state = state;
		setChanged();
		notifyObservers(state);
	}
	
	public String getState() {
		return state;
	}

}

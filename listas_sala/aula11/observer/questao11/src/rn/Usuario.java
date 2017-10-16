package rn;

import util.Subject;

public class Usuario extends Subject {
	
	private String state;
	
	public void setState(String state) {
		this.state = state;
		avisar();
	}
	
	public String getState() {
		return state;
	}

}

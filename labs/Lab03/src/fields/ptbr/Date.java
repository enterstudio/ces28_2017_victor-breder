package fields.ptbr;

import fields.DateInterface;

public class Date implements DateInterface {

	private final int year;
	private final int month;
	private final int day;

	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public String toString() {
		return String.format("%02d/%02d/%04d", day, month, year);
	}

}

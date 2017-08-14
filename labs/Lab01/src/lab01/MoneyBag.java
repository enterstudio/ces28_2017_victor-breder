package lab01;

import java.util.LinkedList;
import java.util.List;

// Processo 7 - Criar classe MoneyBag

public class MoneyBag implements MoneyInterface {

	private List<Money> _monies = new LinkedList<Money>();

	public int size() {
		return _monies.size();
	}

	public MoneyInterface add(Money money) {
		boolean foundSameCurrency = false;
		for (int i = 0; i < size(); i++) {
			if (get(i).getCurrency().equals(money.getCurrency())) {
				get(i).add(money);
				foundSameCurrency = true;
			}
		}
		if (!foundSameCurrency) {
			_monies.add(money);
		}
		return this;
	}

	public void set(int i, Money money) {
		_monies.set(i, money);
	}

	public Money get(int i) {
		return _monies.get(i);
	}

	public boolean contains(Money m) {
		return _monies.contains(m);
	}

	public boolean equals(Object anObject) {
		if (this == anObject)
			return true;
		if (!(anObject instanceof MoneyBag))
			return false;
		MoneyBag otherlist = (MoneyBag) anObject;
		if (!(otherlist.size() == this.size()))
			return false;
		for (int i = 0; i < otherlist.size(); i++) {
			if (!contains(otherlist.get(i)))
				return false;
		}
		return true;
	}

	public String toString() {
		String result = "MoneyBag:\n";
		for (int i = 0; i < size(); i++) {
			result += "* " + get(i) + "\n";
		}
		result += "Total Amount: " + getAmountInBrl() + " BRL";
		return result;
	}

	// Processo 11 - Acrescentar método em MoneyBag que retorna valor total em BRL
	// (1/3)
	public int getAmountInBrl() {
		int amount = 0;
		for (int i = 0; i < size(); i++) {
			amount += get(i).getAmountInBrl();
		}
		return amount;
	}
}

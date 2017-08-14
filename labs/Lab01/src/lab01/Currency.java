package lab01;

// Processo 5 - Criar classe Currency (1/3)

public class Currency {

	private String _currency;
	private int _valueInBrl;

	public Currency(String currency) {
		setCurrency(currency);
		_valueInBrl = 1; // default value for _valueInBrl, if it is not passed in the constructor
	}

	// Processo 11 - Acrescentar método em MoneyBag que retorna valor total em BRL
	// (2/3)
	public Currency(String currency, int valueInBrl) {
		setCurrency(currency);
		_valueInBrl = valueInBrl;
	}

	public int getValueInBrl() {
		return _valueInBrl;
	}

	public void setValueInBrl(int valueInBrl) {
		this._valueInBrl = valueInBrl;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		this._currency = currency;
	}

	public boolean equals(Object object) {
		if (object instanceof Currency) {
			Currency currency = (Currency) object;
			return getCurrency().equals(currency.getCurrency());
		}
		return false;
	}

	public String toString() {
		return _currency;
	}

}

package lab01;

// Processo 1 - Criar a classe Money

public class Money implements MoneyInterface {

	private int _amount;

	// Processo 5 - alterar _currency de String para Currency (2/3)
	private Currency _currency;

	public Money(int amount, Currency currency) {
		setAmount(amount);
		setCurrency(currency);
	}

	public String toString() {
		return "" + getAmount() + " " + getCurrency();
	}

	public boolean equals(Object object) {
		if (object instanceof Money) {
			Money money = (Money) object;
			return money.getCurrency().equals(getCurrency()) && getAmount() == money.getAmount();
		}
		return false;
	}

	// Processo 10 - Modificar método add() de Money para retornar MoneyBag ou Money
	// (1/2)
	public MoneyInterface add(Money money) {
		if (getCurrency().equals(money.getCurrency())) {
			setAmount(getAmount() + money.getAmount());
			return this;
		} else {
			MoneyBag moneyBag = new MoneyBag();
			moneyBag.add(this);
			moneyBag.add(money);
			return moneyBag;
		}
	}

	// Processo 11 - Acrescentar método em MoneyBag que retorna valor total em BRL
	// (3/3)
	public int getAmountInBrl() {
		return getAmount() * getCurrency().getValueInBrl();
	}

	public int getAmount() {
		return _amount;
	}

	public void setAmount(int amount) {
		this._amount = amount;
	}

	// Processo 5 - alterar _currency de String para Currency (3/3)
	public Currency getCurrency() {
		return _currency;
	}

	public void setCurrency(Currency currency) {
		this._currency = currency;
	}

}

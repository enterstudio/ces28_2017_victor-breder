package lab01;

// Processo 9 - aplicação que mostra várias moedas em um MoneyBag

public class Lab01 {

	public static void main(String[] args) {

		Currency brl = new Currency("BRL");
		Currency usd = new Currency("USD", 3);
		Currency chf = new Currency("CHF", 2);

		Money brl40 = new Money(40, brl);
		Money usd30 = new Money(30, usd);
		Money chf70 = new Money(70, chf);

		MoneyBag moneyBag = new MoneyBag();

		moneyBag.add(brl40);
		moneyBag.add(usd30);
		moneyBag.add(chf70);

		System.out.println(moneyBag);

	}

}

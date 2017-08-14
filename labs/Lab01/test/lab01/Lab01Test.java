package lab01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

//Processo 7 - Criar classe MoneyBag

public class Lab01Test {

	private Currency brl;
	private Currency eur;
	private Currency chf;

	private Money brl40;
	private Money brl60;
	private Money eur30;
	private Money chf70;
	private Money brl100;

	private MoneyBag moneyBag;

	@Before
	public void setUp() {
		brl = new Currency("BRL", 1);
		eur = new Currency("EUR", 4);
		chf = new Currency("CHF", 2);

		brl40 = new Money(40, brl);
		brl60 = new Money(60, brl);
		brl100 = new Money(100, brl);
		eur30 = new Money(30, eur);
		chf70 = new Money(70, chf);

		moneyBag = new MoneyBag();
	}

	// Processo 2 - teste para Money.add(Money money) com assertTrue
	@Test
	public void whenAdding40To60Returns100() {
		Money brl100 = (Money) brl40.add(brl60);
		assertTrue(brl100.getAmount() == 100);
	}

	@Test
	public void whenAddingValueTo0ExpectValue() {
		Money money = new Money(0, brl);
		money.add(brl60);
		assertTrue(money.getAmount() == 60);
	}

	// Processo 3 - teste para Money.add(Money money) com assertEquals
	@Test
	public void whenAdding0ToValueExpectValue() {
		Money brl0 = new Money(0, brl);
		brl60.add(brl0);
		assertEquals(60, brl60.getAmount());
	}

	// Processo 10 - Modificar método add() de Money para retornar MoneyBag ou Money
	// (2/2)
	@Test
	public void whenAddingDifferentCurrenciesReturnsMoneyBag() {
		Object sum = brl40.add(eur30);
		assertTrue(sum instanceof MoneyBag);
		MoneyBag moneyBag = (MoneyBag) sum;
		assertTrue(moneyBag.contains(brl40));
		assertTrue(moneyBag.contains(eur30));
	}

	@Test
	public void whenAddedMoneyExpectsMoneyInList() {
		moneyBag.add(brl40);
		assertEquals(brl40, moneyBag.get(0));
	}

	@Test
	public void whenIsEmptySizeReturnsZero() {
		assertEquals(0, moneyBag.size());
	}

	@Test
	public void whenAddedTwoMoneySizeReturns2() {
		moneyBag.add(brl40);
		moneyBag.add(eur30);
		assertEquals(2, moneyBag.size());
	}

	@Test
	public void whenAddingMoniesExpectAddedMoneyInList() {
		moneyBag.add(brl40);
		moneyBag.add(eur30);
		moneyBag.add(chf70);
		assertTrue(moneyBag.contains(eur30));
	}

	@Test
	public void whenAddingMoneisToDifferentBagsExpectBothAreEqual() {
		MoneyBag anotherMoneyBag = new MoneyBag();
		anotherMoneyBag.add(brl40);
		anotherMoneyBag.add(eur30);
		anotherMoneyBag.add(chf70);

		moneyBag.add(chf70);
		moneyBag.add(brl40);
		moneyBag.add(eur30);

		assertEquals(moneyBag, anotherMoneyBag);
	}

	@Test
	public void whenAddingMoniesWithEqualCurrencyExpectSum() {
		moneyBag.add(brl40);
		moneyBag.add(eur30);
		moneyBag.add(brl60);

		assertTrue(moneyBag.contains(brl100));
	}

	@Test
	public void whenAddingMoniesWithDifferentCurrenciesReturnTotalAmountInBrl() {
		moneyBag.add(brl40);
		moneyBag.add(eur30);
		moneyBag.add(chf70);
		assertEquals(300, moneyBag.getAmountInBrl());
	}

	@Test
	public void whenEmptyExpectZeroAsTotalAmountInBrl() {
		assertEquals(0, moneyBag.getAmountInBrl());
	}

	@Test
	public void whenAddingMoneyInBrlExpectSameMoneyAsTotalAmountInBrl() {
		moneyBag.add(brl40);
		assertEquals(40, moneyBag.getAmountInBrl());
	}

}

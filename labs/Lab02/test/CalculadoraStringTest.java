import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculadoraStringTest {

	// TAREFA 1

	@Test
	public void whenPassedAnEmptyStringReturns0() {
		assertEquals(0, CalculadoraString.add(""));
	}

	@Test
	public void whenPassedASingleNumberReturnsNumber() {
		assertEquals(0, CalculadoraString.add("0"));
		assertEquals(2, CalculadoraString.add("2"));
		assertEquals(3, CalculadoraString.add("3"));
		assertEquals(1, CalculadoraString.add(",1"));
	}

	@Test
	public void whenPassedTwoNumbersReturnsSum() {
		assertEquals(3, CalculadoraString.add("1,2"));
		assertEquals(5, CalculadoraString.add("3,2"));
	}

	@Test
	public void whenPassedSpaceBetweenNumbersReturnsSum() {
		assertEquals(3, CalculadoraString.add("1, 2"));
		assertEquals(3, CalculadoraString.add("1 ,2"));
		assertEquals(3, CalculadoraString.add(" 1 ,2"));
		assertEquals(3, CalculadoraString.add(" 1 , 2 "));
		assertEquals(3, CalculadoraString.add("1  , 2"));
		assertEquals(3, CalculadoraString.add("  1 , 2   "));
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenPassedLetterThrowsInvalidArgument() {
		CalculadoraString.add("X");
	}

	@Test
	public void whenPassedThreeNumbersReturnsSum() {
		assertEquals(6, CalculadoraString.add("1, 2, 3"));
		assertEquals(3, CalculadoraString.add("  1, 1 , 1   "));
		assertEquals(2, CalculadoraString.add("  1, 1 ,    "));
		assertEquals(6, CalculadoraString.add("  1, 2 3  "));
	}

	// TAREFA 2
	
	@Test
	public void whenPassedMoreThanTwoNumbersReturnsSum() {
		assertEquals(28, CalculadoraString.add("2,3,5,7,11"));
		assertEquals(28, CalculadoraString.add("2 ,  ,,3,5 ,  , ,7,  11"));
		assertEquals(28, CalculadoraString.add(",,,, 2 ,  ,,3,5 ,  , ,7,  11   ,,,,"));
	}
	
	@Test
	public void whenPassedEmptySpacesWithCommasReturnsZero() {
		assertEquals(0, CalculadoraString.add(","));
		assertEquals(0, CalculadoraString.add(",,,,"));
		assertEquals(0, CalculadoraString.add("  ,,    ,,"));
		assertEquals(0, CalculadoraString.add("   , ,    , ,  "));
	}
	
	// TAREFA 3
	
	@Test
	public void whenPassedNewLineExpectSum() {
		assertEquals(28, CalculadoraString.add("2,\n3,5\n7,\n11"));
		assertEquals(28, CalculadoraString.add("\n2 ,  ,,3,5 , \n , ,7,  11\n"));
		assertEquals(28, CalculadoraString.add(",,\n,, 2 ,  ,\n,3,5 ,  ,\n ,7,  11 \n  ,,,\n,"));
		assertEquals(3, CalculadoraString.add("1\n2"));
		assertEquals(1, CalculadoraString.add("1\n"));
		assertEquals(1, CalculadoraString.add("1,\n"));
	}
	
	// TAREFA 4
	
	@Test
	public void whenDefinedDelimiterExpectSum() {
		assertEquals(6, CalculadoraString.add("//[;]\n1;2;3"));
		assertEquals(6, CalculadoraString.add("//[;]\n1;2,3"));
		assertEquals(6, CalculadoraString.add("//[;]\n1;2 3,"));
		assertEquals(6, CalculadoraString.add("//[;]\n1;\n\n\n;;,2 3,"));
		assertEquals(6, CalculadoraString.add("//[ ]\n1 2 3"));
		assertEquals(66, CalculadoraString.add("//[.]\n11.22.33"));
		assertEquals(66, CalculadoraString.add("//[.*]\n11.*22.*33"));
		assertEquals(66, CalculadoraString.add("//[ ]\n11   22    33"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenEmptyDelimiterThrowException() {
		CalculadoraString.add("//[]\n11   22    33");
	}
}

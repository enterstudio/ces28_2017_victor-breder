import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculadoraStringTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

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
		assertEquals(0, CalculadoraString.add("//[;]\n"));
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
	
	// TAREFA 5
	
	@Test
	public void whenPassedNegativeNumberThrowExceptionWithMessage() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negativos proibidos [-3]");
		CalculadoraString.add("-3");
	}
	
	@Test
	public void whenPassedMultipleNegativeNumbersThrowExceptionWithMessage() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negativos proibidos [-3 -1 -23]");
		CalculadoraString.add("1,3,5,-3,2,-1,0,-23");
	}
	
	// TAREFA 6
	
	@Test
	public void whenPassedNumberLargerThan1000IgnoresIt() {
		assertEquals(2, CalculadoraString.add("2,1001"));
		assertEquals(20, CalculadoraString.add("2,1001,8,5,5"));
		assertEquals(0, CalculadoraString.add(",1001, ,  ,"));
	}
	
	@Test
	public void whenPassedMultipleNumbersLargerThan1000IgnoresThem() {
		assertEquals(7, CalculadoraString.add("1,2000,2,3000,4"));
		assertEquals(30, CalculadoraString.add("5,5,6,4,100000,3,7,31415"));
		assertEquals(30, CalculadoraString.add("2131231,5,5,6,4,100000,3,7,31415,12312123"));
	}
	
	// TAREFA 7
	
	@Test
	public void whenPassedDelimiterWithMultipleCharsExpectCorrectSum() {
		assertEquals(6, CalculadoraString.add("//[***]\n1***2***3"));
		assertEquals(10, CalculadoraString.add("//[***]\n1***2,3\n4"));
		assertEquals(10, CalculadoraString.add("//[--]\n1--2--3--4"));
		assertEquals(10, CalculadoraString.add("//[,,,]\n1,,,2,,,3,,,,4"));
	}
	
	// TAREFA 8
	
	@Test
	public void whenPassedMultipleDelimitersExpectCorrectSum() {
		assertEquals(15, CalculadoraString.add("//[*][!]\n1*2!3!4*5"));
		assertEquals(15, CalculadoraString.add("//[*][!]\n1*2!3,\n,**!4*5"));
	}
	
	// TAREFA 9
	
	@Test
	public void whenPassedMultipleDelimitersWithMultipleCharsExpectCorrectSum() {
		assertEquals(15, CalculadoraString.add("//[***][!!]\n1***2!!3,4\n5"));
		assertEquals(6, CalculadoraString.add("//[***][%%]\n1***2%%3"));
	}
	
	// CORNER CASES
	
	@Test(expected = IllegalArgumentException.class)
	public void whenPassedNumberInDelimiterThrowsException() {
		CalculadoraString.add("//[2][%%]\n1***2%%3");
	}
	
	@Test
	public void whenDashIsDelimiterIgnoreNegatives() {
		assertEquals(15, CalculadoraString.add("//[-]\n -1--2- -3- \n-4-,-5"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenPassedMalformedDelimiterStringThrowsException() {
		CalculadoraString.add("//[**]ç[!]\n1***2%%3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenPassedNoDelimitersThrowsException() {
		CalculadoraString.add("//\n1***2%%3");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenPassedMalformedStringThrowsException() {
		CalculadoraString.add("//[**]");
	}
}

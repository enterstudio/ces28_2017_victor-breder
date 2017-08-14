import java.util.regex.Pattern;

public class CalculadoraString {
	
	/*public static void main(String[] args) {
		String input = "2123123 .* 131232";
		String escaped = Pattern.quote(".*");
		System.out.println(":asdasd " +escaped);
		String[] split = input.split(escaped);
		for (String s : split) {
			System.out.println(s);
		}
	}*/
	
	public static int processPart(String part) {
		if (part.length() == 0) {
			return 0;
		} else {
			return Integer.parseInt(part);
		}
	}
	
	public static int add(String input) {
		String numbers;
		String delimiters = ",|\\s";
		
		if (input.startsWith("//")) {
			String[] split = input.split("\\n", 2);
			String delimiter = split[0].substring(3, split[0].length()-1);
			if (delimiter.length() == 0) {
				throw new IllegalArgumentException();
			}
			String delimiterEscaped = Pattern.quote(delimiter);
			delimiters += "|" + delimiterEscaped;
			numbers = split[1];
		} else {
			numbers = input;
		}
	
		String[] split = numbers.split(delimiters);
		
		if (split.length == 0) {
			return 0;
		} else {
			int sum = 0;
			for (int i = 0; i < split.length; i++) {
				sum += processPart(split[i]);
			}
			return sum;
		}
	}

}

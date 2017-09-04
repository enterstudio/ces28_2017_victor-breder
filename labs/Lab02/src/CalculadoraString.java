import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CalculadoraString {

	private static List<String> parseDelimiters(String string) {
		// Resulting list of delimiters. It is guaranteed to be non-empty
		// and to have only non-empty and non-numeric delimiters.
		ArrayList<String> delimiters = new ArrayList<String>();

		// String is guaranteed to start with "//"
		string = string.substring("//".length());

		// Invariant: the string in consumed each iteration
		while (string.length() > 0) {
			// Consumes the starting "["
			if (!string.startsWith("[")) {
				throw new IllegalArgumentException();
			}
			string = string.substring("[".length());

			// Locates the matching "]"
			int closing = string.indexOf("]");
			if (closing <= 0) { // Found no matching bracket or delimiter is empty
				throw new IllegalArgumentException();
			}

			// Extracts the delimiter
			String delimiter = string.substring(0, closing);
			if (delimiter.matches("\\d")) { // Delimiter containing number is ambiguous
				throw new IllegalArgumentException();
			}

			// Escapes delimiter to prevent it from being interpreted as a Regex formula
			delimiters.add(Pattern.quote(delimiter));

			// Consumes the string. Decreases string.length().
			string = string.substring(closing + 1);
		}

		if (delimiters.isEmpty()) { // Having no defined delimiters is invalid
			throw new IllegalArgumentException();
		}

		return delimiters;
	}

	private static int processPart(String part) throws IllegalArgumentException {
		// It is guaranteed that part is already a trimmed string because " " and "\n" are delimiters

		if (part.length() == 0) { // An empty part defaults to zero
			return 0;
		}

		try { // Rethrows exception if invalid number format
			return Integer.parseInt(part);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	private static String join(String glue, List list) {
		if (list.size() == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(list.get(0).toString());
		for (Object item : list.subList(1, list.size())) {
			sb.append(glue);
			sb.append(item.toString());
		}
		return sb.toString();
	}

	public static int add(String input) throws IllegalArgumentException {
		String query; // Numbers separated by delimiters
		String delimiters = ",|\\s"; // Default delimiters

		if (input.startsWith("//")) { // Input has optional delimiter specification
			int index = input.indexOf("\n");
			if (index < 0) { // Malformed delimiter specification, has no "\n"
				throw new IllegalArgumentException();
			}
			List<String> newDelimiters = parseDelimiters(input.substring(0, index));
			delimiters += "|" + join("|", newDelimiters);
			query = input.substring(index + 1);
		} else { // Input has no optional delimiter specification
			query = input;
		}

		ArrayList<Integer> negatives = new ArrayList<Integer>(); // List of negative numbers in input
		String[] parts = query.split(delimiters);
		int sum = 0;
		for (String part : parts) {
			int number = processPart(part);
			if (number < 0) {
				negatives.add(number);
			} else if (number <= 1000) {
				sum += number;
			}
		}
		if (negatives.size() > 0) {
			throw new IllegalArgumentException("negativos proibidos [" + join(" ", negatives) + "]");
		}
		return sum;
	}

}

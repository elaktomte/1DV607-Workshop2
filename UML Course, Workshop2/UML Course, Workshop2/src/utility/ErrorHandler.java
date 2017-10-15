package utility;

public class ErrorHandler {

	public boolean isInteger (String input) {
		if (input.isEmpty()) {
			System.out.println("Empty string, please enter a new string");
			return false;
		}
		else {
			for (int i = 0; i < input.length(); i++) {
				if (!Character.isDigit(input.charAt(i))) {
					System.out.println("Not a digit. Only digits allowed");
					return false;
				}
			}
			return true;
		}
	}

}

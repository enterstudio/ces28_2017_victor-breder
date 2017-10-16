

public class EmailService {
	
	public void sendEmail(String message, String receiver) {
		message += "\nSent by My iPhone";
		
		System.out.println("Email sent to: " + receiver);
		System.out.println("---");
		System.out.println("Message: " + message);
		System.out.println("---");
		System.out.println();
	}

}

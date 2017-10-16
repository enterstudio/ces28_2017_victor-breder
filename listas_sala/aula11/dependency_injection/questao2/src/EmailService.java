

public class EmailService {
	
	public void sendEmail(String message, String receiver) {
		System.out.println("Email sent to: " + receiver);
		System.out.println("---");
		System.out.println("Message: " + message);
		System.out.println("---");
		System.out.println();
	}

}

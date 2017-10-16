

public class MyApplication {
	
	private EmailService emailService;
	
	public MyApplication(EmailService emailService) {
		this.emailService = emailService;
	}
	
	public void processMessages(String message, String receiver) {
		emailService.sendEmail(message, receiver);
	}

}



public class Main {

	public static void main(String[] args) {
		EmailService emailService = new EmailService();
		MyApplication myApplication = new MyApplication(emailService);
		myApplication.processMessages("Lab de CES-28 é muito legal!", "kabart@gmail.com");
		myApplication.processMessages("Adoro todo esse tempo investido da minha vida nessa matéria!",
				"kabart@gmail.com");

	}

}

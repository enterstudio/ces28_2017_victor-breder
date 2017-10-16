

public class EmailService implements MessageService {
	
	public String sendMessage(String message, String receiver) {	
		return "email:" + receiver + ":" + message;
	}

}

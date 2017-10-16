

public class SMSService implements MessageService {
	
	public String sendMessage(String message, String receiver) {		
		return "sms:" + receiver + ":" + message;
	}

}

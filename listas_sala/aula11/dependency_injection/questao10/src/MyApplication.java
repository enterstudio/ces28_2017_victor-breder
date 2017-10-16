

public class MyApplication {
	
	private MessageService messageService;
	
	public MyApplication(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public String processMessages(String message, String receiver) {
		return messageService.sendMessage(message, receiver);
	}

}

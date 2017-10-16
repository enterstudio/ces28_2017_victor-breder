package questao13;

import questao13.RelaySystem.Publisher;
import questao13.RelaySystem.Subscriber;

public class Main {

	public static void main(String[] args) {
		RelaySystem relaySystem = new RelaySystem();
		
		Subscriber laurival = relaySystem.createSubscriber("dinheiro", "Laurival");
		laurival.subscribe("banco");
		laurival.subscribe("picanha");
		
		Subscriber ivan = relaySystem.createSubscriber("picanha", "Ivan");
		
		Publisher credit = relaySystem.createPublisher("banco");
		Publisher golden = relaySystem.createPublisher("picanha");
		
		credit.publish("Vem ganhar dinheirooo!");
		golden.publish("Vem ser feliz!");

	}

}

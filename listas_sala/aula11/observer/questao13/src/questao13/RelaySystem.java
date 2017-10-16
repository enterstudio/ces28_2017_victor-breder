package questao13;

import java.util.HashSet;
import java.util.Hashtable;

public class RelaySystem {
	
	private Hashtable<String, HashSet<Subscriber>> subscriberMap = new Hashtable<String, HashSet<Subscriber>>();
	
	public Subscriber createSubscriber(String topic, String name) {
		Subscriber subscriber = new Subscriber(this, name);
		subscriber.subscribe(topic);
		return subscriber;
	}
	public Publisher createPublisher(String topic) {
		return new Publisher(this, topic);
	}
	
	public static class Publisher {
		
		private RelaySystem relaySystem;
		private String topic;
		
		private Publisher(RelaySystem relaySystem, String topic) {
			this.relaySystem = relaySystem;
			this.topic = topic;
		}
		
		public void publish(String message) {
			if (relaySystem.subscriberMap.containsKey(topic)) {
				HashSet<Subscriber> subscriberSet = relaySystem.subscriberMap.get(topic);
				for (Subscriber subscriber : subscriberSet) {
					subscriber.receiveMessage(topic, message);
				}
			}
		}

	}
	
	public static class Subscriber {
		
		private RelaySystem relaySystem;
		private String name;
		
		private Subscriber(RelaySystem relaySystem, String name) {
			this.relaySystem = relaySystem;
			this.name = name;
		}
		
		public void subscribe(String topic) {
			if (relaySystem.subscriberMap.containsKey(topic)) {
				relaySystem.subscriberMap.get(topic).add(this);
			} else {
				HashSet<Subscriber> subscriberSet = new HashSet<Subscriber>();
				subscriberSet.add(this);
				relaySystem.subscriberMap.put(topic, subscriberSet);
			}
		}
		public void unsubscribe(String topic) {
			if (relaySystem.subscriberMap.containsKey(topic)) {
				relaySystem.subscriberMap.get(topic).remove(this);
			}
		}
		
		public void receiveMessage(String topic, String message) {
			System.out.println(name + " (" + topic + "): " + message);
		}

	}

}

import java.util.Vector;

public abstract class NetworkInterface extends Protocol{

	private Vector<EventHandler> receiveHandler = new Vector<EventHandler>();

	public void addReceiveHandler(EventHandler handler) {
		receiveHandler.add(handler);
	}

	public void receive(DataPacket dataPacket) {
		for (EventHandler h : receiveHandler) {
		}
	}

	public abstract void send(DataPacket dataPacket);
		
	

	

}

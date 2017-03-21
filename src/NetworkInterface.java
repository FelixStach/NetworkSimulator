import java.util.Vector;

public abstract class NetworkInterface extends Protocol{

	private Vector<NetworkInterfaceEventHandler> receiveHandler = new Vector<NetworkInterfaceEventHandler>();

	public void addReceiveHandler(NetworkInterfaceEventHandler handler) {
		receiveHandler.add(handler);
	}

	public void receive(DataPacket dataPacket) {
		for (NetworkInterfaceEventHandler h : receiveHandler) {
			h.receive(dataPacket);
		}
	}

	public abstract void send(DataPacket dataPacket);
		
	

	

}

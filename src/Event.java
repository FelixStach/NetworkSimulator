
public class Event {
 
	protected double ts;
	protected EventHandler h;
	protected EventType t;
	protected DataPacket p;
	
	public Event(double timestamp, EventHandler h, EventType t, DataPacket packet){
		this.ts = timestamp;
		this.h = h;
		this.t = t;
		this.p = packet;
	}

	public double getTs() {
		return ts;
	}

	public EventHandler getH() {
		return h;
	}

	public EventType getT() {
		return t;
	}

	public DataPacket getP() {
		return p;
	}
	
	
	
}

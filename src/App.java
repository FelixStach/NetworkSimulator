import java.util.Vector;

import SimpleProtocol.SimpleProtocolHandleAbove;
import SimpleProtocol.SimpleProtocolHandleBelow;

public class App extends Protocol{
	private Protocol prevProtocol;
	
	
	private class SimpleProtocolHandleBelow implements EventHandler {
		@Override
		public void processEvent(Event e) {
			switch (e.getT()) {
				case SEND:
					prevProtocol.processEvent(e);
					break;					
				case RECEIVE:
					// TODO Ereignis bei handleAbove erzuegen mit SEND erzeugen
					break;					
			}
		}
	}
	
	
	// konstruktor
	

	public App(Protocol nextProtocol, Protocol prevProtocol) {
		handleAbove = new SimpleProtocolHandleAbove();
		handleBelow = new SimpleProtocolHandleBelow();
		this.nextProtocol = nextProtocol;
		this.prevProtocol = prevProtocol;
	}

}

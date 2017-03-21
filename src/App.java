import java.util.Vector;

import SimpleProtocol.SimpleProtocolHandleAbove;
import SimpleProtocol.SimpleProtocolHandleBelow;

public class App extends Protocol{
	private Protocol nextProtocol;
	private Protocol prevProtocol;
	
	private class SimpleProtocolHandleAbove implements EventHandler {
		@Override
		public void processEvent(Event e) {
			switch (e.getT()) {
				case SEND:
					// TODO auf oberes protokoll zugreifen, Ereignis (RECEIVE) erzeugen bei handlerBelow des oberen Protokolls
					
					break;					
				case RECEIVE:
					// TODO Ereignis bei handleBelow erzuegen mit SEND erzeugen
					
					break;
			}
		}
	}

	
	private class SimpleProtocolHandleBelow implements EventHandler {
		@Override
		public void processEvent(Event e) {
			switch (e.getT()) {
				case SEND:
					// TODO auf unteres protokoll zugreifen, Ereignis (RECEIVE) erzeugen bei handlerAbove des unteren Protokolls
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

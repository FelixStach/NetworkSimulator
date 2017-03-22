
public class SimpleProtocol extends Protocol {
	
	private SimpleProtocol nextProtocol;
	private SimpleProtocol prevProtocol;
	
	private class SimpleProtocolHandleAbove implements EventHandler {
		@Override
		public void processEvent(Event e) {
			switch (e.getT()) {
				case SEND:
					//prevProtocol.processEvent(e);
					
					break;					
				case RECEIVE:
					//nextProtocol.processEvent(e);
					
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
	

	public SimpleProtocol(Protocol nextProtocol, Protocol prevProtocol) {
		handleAbove = new SimpleProtocolHandleAbove();
		handleBelow = new SimpleProtocolHandleBelow();
		//this.nextProtocol = nextProtocol;
		//this.prevProtocol = prevProtocol;
	}

}

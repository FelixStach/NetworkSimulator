
public class NetworkInterface extends Protocol {

	private Node node;

	private class SimpleProtocolHandleAbove implements EventHandler {
		@Override
		public void processEvent(Event e) {
			switch (e.getT()) {
			case SEND: {
				Event newEvent = new Event(e.getTs() + 0.001, above.handleBelow, EventType.RECEIVE, e.getP());
				World.getScheduler().schedule(newEvent);
				break;
			}
			case RECEIVE: {
				Event newEvent = new Event(e.getTs() + 0.001, handleBelow, EventType.SEND, e.getP());
				World.getScheduler().schedule(newEvent);
				break;
			}
			}
		}
	}

	private class SimpleProtocolHandleBelow implements EventHandler {
		@Override
		public void processEvent(Event e) {
			switch (e.getT()) {
			case SEND: {
				Event newEvent = new Event(e.getTs() + 0.001, below.handleAbove, EventType.RECEIVE, e.getP());
				World.getScheduler().schedule(newEvent);
				break;
			}
			case RECEIVE: {
				Event newEvent = new Event(e.getTs() + 0.001, handleAbove, EventType.SEND, e.getP());
				World.getScheduler().schedule(newEvent);
				break;
			}
			}
		}
	}

	// konstruktor

	public NetworkInterface(Node node, Protocol nextProtocol, Protocol prevProtocol) {
		this.node = node;
		handleAbove = new SimpleProtocolHandleAbove();
		handleBelow = new SimpleProtocolHandleBelow();
	}

}

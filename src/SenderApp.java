import java.util.Vector;


public class SenderApp extends Protocol{
	
	private double interval; 
  
  
  private class SenderAppHandleBelow implements EventHandler {
	  
    @Override
    
    public void processEvent(Event e) {
      switch (e.getT()) {
        case SEND:
        	// send to below protocol
        	DataPacket dp = new DataPacket();
        	Event ne = new Event(1, below.getHandlerAbove(), EventType.RECEIVE, dp);
        	World.getScheduler().schedule(ne);
        	
        	// create next send event
        	Event ne2 = new Event(e.getTs() + interval, handleBelow, EventType.SEND, null);
        	World.getScheduler().schedule(ne2);
          break;          
        case RECEIVE:
          break;          
      }
    }
  }
  
  
  // konstruktor
  

  public SenderApp(double first, double interval) {
	  this.interval = interval;
	  handleBelow = new SenderAppHandleBelow();
	  Event e = new Event(first, handleBelow, EventType.SEND, null);
	  World.getScheduler().schedule(e);
  }

}

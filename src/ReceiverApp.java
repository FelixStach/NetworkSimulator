import java.util.Vector;


public class ReceiverApp extends Protocol{ 
  
  
  private class ReceiverAppHandleBelow implements EventHandler {
	  
    @Override
    
    public void processEvent(Event e) {
      switch (e.getT()) {
        case SEND:
          break;          
        case RECEIVE:
        	System.out.println(e.getTs());
          break;          
      }
    }
  }
  
  
  // konstruktor
  

  public ReceiverApp() {
	  handleBelow = new ReceiverAppHandleBelow();
  }

}

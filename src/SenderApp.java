import java.util.Vector;

public class App extends Protocol{
  private Protocol prevProtocol;
  
  
  private class SimpleProtocolHandleBelow implements EventHandler {
    @Override
    public void processEvent(Event e) {
      switch (e.getT()) {
        case SEND:
          
          break;          
        case RECEIVE:
          // TODO Ereignis bei handleAbove erzuegen mit SEND erzeugen
          break;          
      }
    }
  }
  
  
  // konstruktor
  

  public App(Protocol nextProtocol, Protocol prevProtocol) {
  //  handleAbove = new SimpleProtocol();
  //  handleBelow = new SimpleProtocol();
  //  this.nextProtocol = nextProtocol;
  //  this.prevProtocol = prevProtocol;
  }
  
  public Protocol getPrevProtocol() {
    return prevProtocol;
    }

}

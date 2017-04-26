import java.util.Vector;

public class World {

  
  private Vector<Node> knotenliste = new Vector<Node>();
  
  private static Scheduler sched = null;
  
  public static Scheduler getScheduler() {
    if (sched == null) {
      sched = new SimpleScheduler();
    }
    return sched;
  }
  
  
  public static void main (String args []) {
    
    Node node1 = new Node(10,10);
    Node node2 = new Node(20,20);
    
    SimpleProtocol protocol1 = new SimpleProtocol();
    SimpleProtocol protocol2 = new SimpleProtocol();
    ReceiverApp standardApp = new ReceiverApp();
    
    
    SimpleProtocol protocol3 = new SimpleProtocol();
    SimpleProtocol protocol4 = new SimpleProtocol();
    SenderApp tolleApp = new SenderApp(1.0,5.0);
    
    node1.addProtocol(protocol1);
    node1.addProtocol(protocol2);
    node1.addProtocol(standardApp);
    
    node2.addProtocol(protocol3);
    node2.addProtocol(protocol4);
    node2.addProtocol(tolleApp);
    
    node1.attachNode(node2);
    
    while (sched.next() != null) {
    	sched.processNext();
    }
  }
}

import java.util.*;
/**
 * 
 * @author felix.stach
 *
 */

public class Node {

  private double x;
  private double y;
  private NetworkInterface netInf = new NetworkInterface(null, null);                         //Standard-NetInf
  private LinkedList<Protocol> protocols = new LinkedList<Protocol>();
  
  public Node(int x, int y ) {
    this.x = x; 
    this.y = y;
    protocols.add(netInf);
  }
  
  public void addProtocol(Protocol p) {
    Protocol last = protocols.getLast();
    
    last.setAbove(p);
    protocols.add(p);
    p.setBelow(last); 
  }
  
  private LinkedList<Protocol> getProtocols() {
  return protocols;
    }
  
}

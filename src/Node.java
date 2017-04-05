import java.util.*;
import java.lang.*;
/**
 * 
 * @author felix.stach
 *
 */

public class Node {

  private double x;
  private double y;
  private double rangeOfSignal = 20;
  
  
  private NetworkInterface netInf = new NetworkInterface(this, null, null);     //Standard-NetInf
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
  
  public void attachNode(Node otherNode) {
	  otherNode.netInf.below = this.netInf;
	  this.netInf.below = otherNode.netInf;
  }
  
  
//  public void sendDataPacket(Node otherNode, DataPacket data) {
//	  if ( Math.sqrt((otherNode.getX() - this.getX()) * (otherNode.getX() - this.getX()) + (otherNode.getY() - this.getY()) * (otherNode.getY() - this.getY())) < rangeOfSignal) {
//		  
//	  }
//	  else
//		  System.out.println("Nicht in Reichweite");
//	  
//  
//  }
  
  
  
  public double getX() {
	  return x;
  }
  
  public double getY() {
	  return y;
  }
  
  public LinkedList<Protocol> getProtocols() {
	  return protocols;
   }
  
}

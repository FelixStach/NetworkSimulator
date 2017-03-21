/**
 * 
 * @author felix.stach
 *
 */

public class Node {

	private double x;
	private double y;
	private NetworkInterface netInf;													//Standard-App
	private List<Protocol> protocols = new List<Protocol>();
	
	public Node(int x, int y, ) {
		this.x = x; 
		this.y = y;
		protocols.add(netInf);
	}
	
	public static void addProtocol(Protocol p) {
		Protocol last = protocols.getLast();
		
		last.setAbove(p);
		protocols.add(p);
		p.setBelow(last);	
	}
}

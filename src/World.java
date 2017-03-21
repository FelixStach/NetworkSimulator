import java.util.Vector;

public class Welt {
	private Vector<Knoten> knotenliste = new Vector<Knoten>();
	
	public static void main (String args []) {
		
		Node node1 = new Node(10,10);
		Node node2 = new Node(20,20);
		
		SimpleProtocol protocol1(null, null) = new SimpleProtocol;
		SimpleProtocol protocol2(null, null) = new SimpleProtocol;
		App standardApp = new App(null, null);
		
		node1.addProtocol(protocol1);
		node1.addProtocol(protocol2);
		node1.addProtocol(standardApp);
		
		node2.addProtocol(protocol1);
		node2.addProtocol(protocol2);
		node2.addProtocol(standardApp);
	}
}

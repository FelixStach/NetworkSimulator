
public class MinimumHeapScheduler implements Scheduler {
	
	
	@Override
	public void processNext() {
		// TODO Auto-generated method stub

	}

	@Override
	public Event next() {
		// TODO Auto-generated method stub
		return null;
	}

	private MinimumHeapNode root;
	private int n;
	

	public MinimumHeapScheduler() {
		root = null;
		n = 0;
	}

	

	
	private MinimumHeapNode getNodeAtIndex(int n, boolean enter){
		int z = 1;
		while (z <= n) {
			z = z * 2;
		}

		z = z / 2;
		int m = n - z;
		MinimumHeapNode aktuell = root;
		z = z / 2;

		while (z > 1) { //=> ?
			if (m >= z) {
				m = m - z;
				z = z / 2;
				aktuell = aktuell.getrSon(); // zu dem rechten Son (n+1)
			} else {
				z = z / 2;
				aktuell = aktuell.getlSon(); // zu dem linken Son (n+0)
			}
		}
		
		if(enter){
			if (m == 0) {
				//links
				aktuell = aktuell.getlSon(); // zu dem linken Son (n+0)
			} else {
				aktuell = aktuell.getrSon(); // zu dem rechten Son (n+1)
				//rechts		
			}
		}
		
		return aktuell;
	}
	
	
	@Override
	public void schedule(Event e) {
		//Als erstes muss die Wurzel gesetzt werden --> dadurch wird n eins höher gesetzt
		//Anschließend sucht man den letzten vorhandenen Knoten im Baum --> speichert ihn in aktuell
		//Erzeuge nun einen neuen Knoten mit aktuell als Vater
		//Nun entscheiden ob links oder rechts anhängen
		// Dann anhängen
		//darauf dann nach oben hin durch tauschen, bis der Vater kleiner ist als der neue Knoten
		n++;
		if (root == null) {
			root = new MinimumHeapNode(e, null, null, null);
			return;
		}

		
		MinimumHeapNode aktuell = getNodeAtIndex(n, false);
		

		MinimumHeapNode newNode = new MinimumHeapNode(e, aktuell, null, null);
     	if (aktuell.getlSon() == null) {
			//links
     		aktuell.setlSon(newNode);
		} else {
			aktuell.setrSon(newNode);
			//rechts		
		}
     	
     	while(newNode.getFather()!=null && newNode.getEvent().getTs() < newNode.getFather().getEvent().getTs()){
     		Event temp = newNode.getFather().getEvent();
     		newNode.getFather().setEvent(newNode.getEvent());
     		newNode.setEvent(temp);
     		newNode = newNode.getFather();
     	}     	
	}
	
	private void tauschenRunter(MinimumHeapNode aktuell){
		while(aktuell.getlSon()!= null && (
				aktuell.getEvent().getTs() > aktuell.getlSon().getEvent().getTs() || 
				aktuell.getEvent().getTs() > aktuell.getrSon().getEvent().getTs() )) {
			Event temp = aktuell.getEvent();
			if (aktuell.getrSon()!= null && aktuell.getlSon().getEvent().getTs() > aktuell.getrSon().getEvent().getTs()) {
				aktuell.setEvent(aktuell.getrSon().getEvent());
				aktuell.getrSon().setEvent(temp);
				aktuell = aktuell.getrSon();
			} else {
				aktuell.setEvent(aktuell.getlSon().getEvent());
				aktuell.getlSon().setEvent(temp);
				aktuell = aktuell.getlSon();
			}
		}

	}
	
	
	
	
	public Event extractMin(){
		// man entfernt das Element aus der Wurzel 
		// -> fügt das letzte Element des Baums in die Wurzel
		// -> wenn größer als Sohn, dann tauschen, sodass die kleinste Zahl oben steht
		if(root==null){
			return null;
		}
		Event ev = root.getEvent();
		if(n==1){
			root=null;
			n=0;
			return ev;
		}
		
		MinimumHeapNode aktuell = getNodeAtIndex(n, true);
		root.setEvent(aktuell.getEvent());
		
		if(aktuell.getFather().getlSon()== aktuell){
		    aktuell.getFather().setlSon(null);
		}else{
			aktuell.getFather().setrSon(null);
		}
		

		tauschenRunter(root);
		// TODO null Pointer exception beachten
		
		return ev;
	}
	
	
	

	@Override
	public void cancel(Event e) {
		//ein Zeiger muss auf den Knoten zeigen, wo das Event gespeichert ist, welches man löschen will
		//der anderer Zeiger verweist auf das letzte Event im Baum
		//danach wird das eine Event mit dem letzten Event überschrieben
		// der last wird null gesetzt
		//dann muss man schauen, ob der aktuell getauscht werden muss		
		MinimumHeapNode aktuell = suche(root, e);  //von dem Event e
		MinimumHeapNode last = getNodeAtIndex(n-1,true); // für das letzte Event des Baums
		if(aktuell.getEvent()!=null){
			aktuell.setEvent(last.getEvent());
		}
		
		if(last.getFather().getlSon()== last){
		    last.getFather().setlSon(null);
		}else{
			last.getFather().setrSon(null);
		}
		tauschenRunter(aktuell);
		

	}
	
	public MinimumHeapNode suche(MinimumHeapNode b, Event e){ //um einem bestimmten Knoten mit einem bestimmten Event zu suchen
		//
		if(e.equals(b.getEvent())){
			return b;
		}
		if(b.getlSon()!= null){
			MinimumHeapNode found = suche(b.getlSon(), e);
			if(found!= null){
				return found;
			}
		}
		if(b.getrSon()!= null){
			MinimumHeapNode found = suche(b.getrSon(), e);
			if(found!= null){
				return found;
			}
		}
		return null;
	}
	
	

	@Override
	public void cancelAll() {
	n=0;
	MinimumHeapNode lSon = null;
	MinimumHeapNode rSon = null;
	MinimumHeapNode father = null;
	MinimumHeapNode root = null;
	
	}

}

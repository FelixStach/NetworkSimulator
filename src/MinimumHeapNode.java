
public class MinimumHeapNode {

	private Event event;
	private MinimumHeapNode father;
	private MinimumHeapNode lSon;
	private MinimumHeapNode rSon;
	
	public MinimumHeapNode(Event event, MinimumHeapNode father, MinimumHeapNode lSon, MinimumHeapNode rSon) {
		super();
		this.event = event;
		this.father = father;
		this.lSon = lSon;
		this.rSon = rSon;
	}

	public Event getEvent() {
		return event;
	}

	public MinimumHeapNode getFather() {
		return father;
	}

	public MinimumHeapNode getlSon() {
		return lSon;
	}

	public MinimumHeapNode getrSon() {
		return rSon;
	}

	public void setlSon(MinimumHeapNode lSon) {
		this.lSon = lSon;
	}

	public void setrSon(MinimumHeapNode rSon) {
		this.rSon = rSon;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void setFather(MinimumHeapNode father) {
		this.father = father;
	}
	
	
	
	
}

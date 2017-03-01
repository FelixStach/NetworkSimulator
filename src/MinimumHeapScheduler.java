
public class MinimumHeapScheduler implements Scheduler {

	private MinimumHeapNode root;
	private int n;
	

	public MinimumHeapScheduler() {
		root = null;
		n = 0;
	}

	@Override
	public void processNext() {
		// TODO Auto-generated method stub

	}

	@Override
	public Event next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void schedule(Event e) {
		n++;
		if (root == null) {
			root = new MinimumHeapNode(e, null, null, null);
			return;
		}

		int z = 1;
		while (z <= n) {
			z = z * 2;
		}

		z = z / 2;
		int m = n - z;
		MinimumHeapNode aktuell = root;
		z = z / 2;

		while (z > 1) {
			if (m >= z) {
				m = m - z;
				z = z / 2;
				aktuell = aktuell.getrSon(); // zu dem rechten Son (n+1)
			} else {
				z = z / 2;
				aktuell = aktuell.getlSon(); // zu dem linken Son (n+0)
			}
		}

		MinimumHeapNode newNode = new MinimumHeapNode(e, aktuell, null, null);
     	if (m == 0) {
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
	
	
	

	@Override
	public void cancel(Event e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelAll() {
		// TODO Auto-generated method stub

	}

}

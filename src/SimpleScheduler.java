import java.util.Vector;

public class SimpleScheduler implements Scheduler {

	private Vector<Event> events = new Vector<Event>(50);

	@Override
	public void processNext() {
		Event e = events.remove(0);
		e.getH().processEvent(e);
	}
	
	@Override
	public Event next() {
		return events.size() > 0 ? events.get(0) : null;	// obsolete error 1
	}
	
	@Override
	public void schedule(Event e) {
		int i= 0;
		while(i < events.size() && events.get(i).getTs() < e.getTs()){	// obsolete error 2
			i++;
		}
		events.insertElementAt(e, i);
	}
	
	@Override
	public void cancel(Event e) {
		if (e != null) {
			events.remove(e);
		}
	}
	
	@Override
	public void cancelAll(){
		events.clear();
	}

}

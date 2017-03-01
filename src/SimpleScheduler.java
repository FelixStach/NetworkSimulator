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
		return events.get(0);
	}
	
	@Override
	public void schedule(Event e) {
		int i= 0;
		while(events.get(i).getTs() < e.getTs()){
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

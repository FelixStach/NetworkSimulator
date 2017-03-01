
public interface Scheduler {

	public void processNext();
	public Event next();	
	public void schedule(Event e);
	public void cancel(Event e);	
	public void cancelAll();		
}


public abstract class Protocol  {

	protected Protocol above = null;	
	protected EventHandler handleAbove = null;
	protected EventHandler handleBelow = null;
	protected Protocol below = null;

	
	public EventHandler getHandlerAbove() {
		return handleAbove;
	}


	public EventHandler getHandlerBelow() {
		return handleBelow;
	}


	public Protocol getAbove() {
		return above;
	}


	public Protocol getBelow() {
		return below;
	}
	
	public void setAbove(Protocol p) {
		above = p;
	}
	
	public void setBelow(Protocol p) {
		below = p;
	}
	
}

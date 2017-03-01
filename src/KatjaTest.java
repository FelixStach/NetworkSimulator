
public class KatjaTest {

	public static void main(String[] args) {
		Event e1 = new Event(1.0, null, null, null);
		Event e2 = new Event(1.2, null, null, null);
		Event e3 = new Event(0.5, null, null, null);
		Event e4 = new Event(2.0, null, null, null);
		Event e5 = new Event(2.2, null, null, null);
		Event e6 = new Event(3.5, null, null, null);
		Event e7 = new Event(4.6, null, null, null);
		Event e8 = new Event(5.2, null, null, null);
		Event e9 = new Event(10.5, null, null, null);
		Event e10 = new Event(16.0, null, null, null);
		Event e11 = new Event(1.4, null, null, null);
		Event e12 = new Event(12.5, null, null, null);
		Event e13 = new Event(15.0, null, null, null);

		
		MinimumHeapScheduler b = new MinimumHeapScheduler();
		b.schedule(e1);
		b.schedule(e2);
		b.schedule(e3);
		b.schedule(e4);
		b.schedule(e5);
		b.schedule(e6);
		b.schedule(e7);
		b.schedule(e8);
		b.schedule(e9);
		b.schedule(e10);
		b.schedule(e11);
		b.schedule(e12);
		b.schedule(e13);
	}

}

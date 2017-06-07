

public class Vergleich {
	public static void main(String[] args) {
/*		for (int n = 10; n <= 50000; n += 100)
			runTestSimple(n);*/
		for (int n = 10; n <= 50000; n += 100)
			runTestMinHeap(n);
	}
	
	public static void runTestSimple(long n) {
		 SimpleScheduler s = new SimpleScheduler();
		 double t = measureTime(s,n);
		 System.out.printf("Simple: %d = %.6f\n", n, t);
	}

	public static void runTestMinHeap(long n) {
		 MinimumHeapScheduler p = new MinimumHeapScheduler();		 
		 double t = measureTime(p,n);
		 System.out.printf("MinHeap: %d = %.6f\n", n, t);
	}
	
	
	public static void scheduleRandomEvents(Scheduler scheduler, long n) {
		for(long i = 0; i < n; i++) {
			double ts = (Math.random()*1000);
			Event e = new Event(ts,null,null,null);
			scheduler.schedule(e);
		}
   }
	
	public static double measureTime(Scheduler scheduler, long n){
		long time_start = System.nanoTime();
		scheduleRandomEvents(scheduler, n);
		long time_diff = System.nanoTime()- time_start;
		return time_diff / 1000000000.0;
	}
	
}

package Gen;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CollectingControl {
	
	public static void main(String[] args) throws InterruptedException {
		
		
//		ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(5);
		
		
		
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
			public void run(){
				CollectinSV cs = new CollectinSV();
				cs.CollectSending();
				}
			}, 0, 1, TimeUnit.MINUTES);
//		for (int i = 0; i< 5; i++){
//		//		RMI_client rc = new RMI_client();
//				CollectinSV cs = new CollectinSV();
//				scheduledPool.schedule(cs, 0, TimeUnit.SECONDS);
//			//	System.out.println("new thread start");
//				Thread.sleep(10000);
//			}
////				
//		Thread.sleep(3000);
//			
//		scheduledPool.shutdown();
//			
//		while(!scheduledPool.isTerminated()){
//				}
//			
//		System.out.println("all finished");
	}
}

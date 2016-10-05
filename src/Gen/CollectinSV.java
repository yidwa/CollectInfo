package Gen;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.DiskUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.ProcMem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarProxy;
import org.hyperic.sigar.SigarProxyCache;





public class CollectinSV implements Serializable, Job{
	
	ArrayList<Double> cpu;
	double mem;
	private Sigar sigar;
	private SigarProxy proxy;
	
	public static DecimalFormat df = new DecimalFormat("#.##");
	

	public CollectinSV(){
		cpu = new ArrayList<Double>();
		mem = 0;
	}
	
	
	
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		try {
//		
//		} catch (SigarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public ArrayList<Double> cpuInfo() throws SigarException {
		
		sigar = SigarInit.sigarInit(false);
		// get the cpu list
		CpuPerc[] cpus = sigar.getCpuPercList();
		for (int i = 0; i < cpus.length; i++) {
//			System.out.println("user "+ cpus[i].getUser()+ " sys "+ cpus[i].getSys());
			double usage = cpus[i].getSys()+cpus[i].getUser();
//			System.out.println("usage "+ df.format(usage));
//			double usage = cpus[i].getSys()+cpus[i].getUser();
			cpu.add(Double.valueOf(df.format(usage)));			
//			System.out.println("cpu usage "+ cpus[i].getSys());
		}

//		System.out.println("cpu info "+cpu.toString());
		return cpu;
	}
	public double memInfo() throws SigarException {
	    
	    Mem m = sigar.getMem();
	    double mem = Double.valueOf(df.format(m.getUsedPercent()));
 
	    return mem;

	}
	
	
	
//	public static void main(String[] args) throws InterruptedException {
//		ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(5);
//	
//		for (int i = 0; i< 2; i++){
//				CollectinSV cp = new CollectinSV();
////				CollectMem cm = new CollectMem();
//				scheduledPool.schedule(cp, 0, TimeUnit.SECONDS);
//
////				scheduledPool.schedule(cm, 0, TimeUnit.SECONDS);
//			//	System.out.println("new thread start");
//				Thread.sleep(5000);
//			}
//				
//		Thread.sleep(3000);
//			
//		scheduledPool.shutdown();
//			
//		while(!scheduledPool.isTerminated()){
//			}
////		TimerTask tt = new CollectinSV();
////		Timer t = new Timer();
////		t.scheduleAtFixedRate(tt, 1000, 5000);
////		System.out.println("all finished");
//		
//	}



	@Override
	public String executeJob() throws RemoteException {
		// TODO Auto-generated method stub
		try {
			cpu = cpuInfo();
			mem = memInfo();
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String temp = cpu.toString()+ " "+ mem;
		return temp;
	}
}

package Gen;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarProxy;
import org.hyperic.sigar.SigarProxyCache;

public class SigarInit {
	static Sigar sigar;
	static SigarProxy proxy;

	static Sigar sigarInit(boolean isProxy) {
		sigar = new Sigar();
		if (isProxy) {
			setProxy(SigarProxyCache.newInstance(sigar));
		}
		return sigar;
	}
	
	 static void setProxy(SigarProxy proxy) {
		proxy = proxy;
	}
}

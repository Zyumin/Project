package lang.mxbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-09-15 09:52
 */
public class MxBeanDemo {
    public static void main(String[] args) {

         ThreadMXBean
                  server =  ManagementFactory.getThreadMXBean();

        RuntimeMXBean rt = ManagementFactory.getRuntimeMXBean();

        MBeanServer s =  ManagementFactory.getPlatformMBeanServer();

    }
}
